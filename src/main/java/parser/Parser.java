package parser;

import grammar.Char;
import grammar.NTChar;
import grammar.Grammar;

import wordanalyzer.Word;
import wordanalyzer.words.WD;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//SLR(1)语法分析器
public class Parser {
    //产生式
    private final ArrayList<NTChar> G;

    //文法符号集
    private final LinkedHashSet<Char> X;

    //项目集族
    //C是一个集合，其中集合的元素又是一个集合，value集合描述了DFA中每一个节点的产生式
    private final LinkedHashSet<LinkedHashSet<Item>> C = new LinkedHashSet<>();

    //FIRST集
    private final HashMap<Char, HashSet<Word>> FIRST = new HashMap<>();

    //FOLLOW集
    private final HashMap<NTChar, HashSet<Word>> FOLLOW = new HashMap<>();

    //SLR(1)分析表
    private final ParseTable table = new ParseTable();

    public Parser() { //在构造函数中初始化goto表和action表
        G = Grammar.getG();
        X = Grammar.getX();
        doMakeTable();
    }

    /**
     * 求给定项目集I的闭包
     * CLOSURE(I)＝I∪{B→·γ|A→α·Bβ∈CLOSURE(I), B→γ∈P}
     * 思路
     * 1. 第一步首先枚举所有的A→α·Bβ
     * 2. 第二步在G中枚举所有的B→γ
     * 3. 将所有符合条件的B→γ加入到闭包中
     * @param I 项目集
     * @return java.util.LinkedHashSet<parser.Item>
     * @author 李电楠
     */
    private LinkedHashSet<Item> CLOSURE(LinkedHashSet<Item> I) {
        LinkedHashSet<Item> J = new LinkedHashSet<>();
        int size;
        do {
            size = I.size();
            //I中的每个项A→α∙Bβ
            for (Item A : I) {
                ArrayList<Char> prod = A.getLeftChar().getProdRight(); //枚举每个项的right集合
                int pointPos = A.getPointPos();
                //A不是归约项目
                if (pointPos < prod.size()) {
                    Char B = prod.get(pointPos);
                    //B是非终结符
                    if (!B.isTerminal()) {
                        //G的每个产生式B→γ
                        for (NTChar p : G) {
                            if (B.equals(p)) {
                                //将B→∙γ加入J中
                                J.add(new Item(p, 0));
                            }
                        }
                    }
                }
            }
            //将J合并到I中
            I.addAll(J);
            J.clear();
        } while (size != I.size()); //终止的条件是size不再增大
        return I;
    }

    /**
     * 求项目集I对应于文法符号X的后继项目集闭包
     * GOTO(I, X)＝CLOSURE({A→αX·β|A→α·Xβ∈I})
     * 注意这里的后继项目集是指哪些能够推出X，而不是X能推出谁，因为我们执行的是自低向上的分析
     * 算法
     * 1. 枚举项目集中的所有项目
     * 2. check一下是否有A→αX·β存在
     * 3. 如果有的话就丢金集合J
     * 4. 求集合J的闭包
     * @param I 项目集
	 * @param X 文法符号
     */
    private LinkedHashSet<Item> GOTO(LinkedHashSet<Item> I, Char X) {
        //将J初始化为空集
        LinkedHashSet<Item> J = new LinkedHashSet<>();
        //I中的每个项A→α∙Xβ
        for (Item A : I) {
            ArrayList<Char> prod = A.getLeftChar().getProdRight();
            int pointPos = A.getPointPos();
            if (pointPos < prod.size() && prod.get(pointPos).equals(X)) { //找到一个满足条件的A→αX∙β
                //将项A→αX∙β加入集合J中
                J.add(new Item(A.getLeftChar(), pointPos + 1));
            }
        }
        return CLOSURE(J);
    }

    /**
     * 求项目集族
     * C＝{I0}∪{I|∃J∈C, X∈VN∪VT, I＝GOTO(J, X)}
     * C表示DFA的所有节点
     * 思路和求GOTO集合类似，只是这里的Node从产生式变成了集合
     */
    private void doMakeC() {
        //C＝{CLOSURE({[S'→·S]})}
        LinkedHashSet<Item> I0 = new LinkedHashSet<>();
        I0.add(new Item(new NTChar(WD.S_).a(new NTChar(WD.S)), 0));
        C.add(CLOSURE(I0));
        LinkedHashSet<LinkedHashSet<Item>> J = new LinkedHashSet<>();
        int size;
        do {
            size = C.size();
            //C中的每个项集I
            for (LinkedHashSet<Item> I : C) {
                //每个文法符号x
                for (Char x : X) {
                    LinkedHashSet<Item> g = GOTO(I, x); //这里要求出goto集合
                    if (!g.isEmpty()) {
                        //将GOTO(I, X)加入C中
                        J.add(g);
                    }
                }
            }
            //将J合并到C中
            C.addAll(J);
            J.clear();
        } while (size != C.size()); //终止条件为C的大小不再增大
    }

    /**
     * 求FIRST集
     * 由于文法中不存在ε，此处没有考虑存在ε的情况
     * FIRST(X)表示由X开始推导，第一个可能推出的a \in T
     *
     */
    private void doMakeFIRST() {
        for (Char x : X) {
            HashSet<Word> Fx = new HashSet<>();
            //如果x是一个终结符，那么FIRST(X)＝{X}
            if (x.isTerminal()) Fx.add((Word) x);
            FIRST.put(x, Fx);
        }
        int startSize;
        AtomicInteger endSize = new AtomicInteger(0);
        do {
            startSize = endSize.get();
            //G中的每个产生式X→Y1…Yk(k≥1)
            for (NTChar X : G) {
                //将FIRST(Y1)合并到FIRST(X)中
                FIRST.get(X).addAll(FIRST.get(X.getProdRight().get(0)));
            }
            endSize.set(0);
            FIRST.forEach((x, tChar) -> endSize.addAndGet(tChar.size()));
        } while (startSize != endSize.get());
    }

    /**
     * 求FOLLOW集
     * 由于文法中不存在ε，此处没有考虑存在ε的情况
     *
     * @author 李电楠
     */
    private void doMakeFOLLOW() {
        for (Char x : X) {
            if (!x.isTerminal()) FOLLOW.put((NTChar) x, new HashSet<>());
        }
        //将#加入FOLLOW(S)中
        FOLLOW.get(new NTChar(WD.S)).add(new Word(WD.END));
        int startSize;
        AtomicInteger endSize = new AtomicInteger(1);
        do {
            startSize = endSize.get();
            for (NTChar A : G) {
                ArrayList<Char> right = A.getProdRight();
                for (int i = 0; i < right.size() - 1; i++) {
                    //存在一个产生式A→αBβ
                    if (!right.get(i).isTerminal()) {
                        //将FIRST(β)合并到FOLLOW(B)中
                        NTChar B = (NTChar) right.get(i);
                        FOLLOW.get(B).addAll(FIRST.get(right.get(i + 1)));
                    }
                }
                //存在一个产生式A→αB
                if (!right.get(right.size() - 1).isTerminal()) {
                    //将FOLLOW(A)合并到FOLLOW(B)中
                    NTChar B = (NTChar) right.get(right.size() - 1);
                    FOLLOW.get(B).addAll(FOLLOW.get(A));
                }
            }
            endSize.set(0);
            FOLLOW.forEach((x, tChar) -> endSize.addAndGet(tChar.size()));
        } while (startSize != endSize.get());
    }

    /**
     * 求SLR(1)分析表
     * 思路
     * 1. 构造项目集族
     * 2. 构造FIRST集
     * 3. 构造FOLLOW集
     * 4. 构造GOTO表和ACTION表
     */
    private void doMakeTable() {
        //构造G'的规范LR(0)项集族C＝{I0, I1, …, In}
        doMakeC();
        doMakeFIRST();
        doMakeFOLLOW();
        ArrayList<LinkedHashSet<Item>> I = new ArrayList<>(C);
        table.setACTION(new HashMap[I.size()]);
        table.setGOTO(new HashMap[I.size()]);
        for (int i = 0; i < I.size(); i++) {
            table.getACTION()[i] = new HashMap<>();
            table.getGOTO()[i] = new HashMap<>();
            LinkedHashSet<Item> Ii = I.get(i);
            for (Item item : Ii) {
                NTChar A = item.getLeftChar();
                if (item.getPointPos() < A.getProdRight().size()) {
                    //A→α·aβ∈Ii
                    if (A.getProdRight().get(item.getPointPos()).isTerminal()) {
                        //GOTO(Ii, a)＝Ij
                        Word a = (Word) A.getProdRight().get(item.getPointPos());
                        int j = I.indexOf(GOTO(Ii, a));
                        //ACTION[i, a]＝sj
                        table.getACTION()[i].put(a, new ParseTable.A_i("s", j));
                    }
                    //A→α.Bβ∈Ii
                    else {
                        //GOTO(Ii, B)＝Ij
                        NTChar B = (NTChar) A.getProdRight().get(item.getPointPos());
                        int j = I.indexOf(GOTO(Ii, B));
                        //GOTO[i, B]＝j
                        table.getGOTO()[i].put(B, new ParseTable.G_i(j));
                    }
                }
                //A→α·∈Ii且A≠S'
                else if (!(A.getMy_type() == WD.S_)) {
                    for (int j = 0; j < G.size(); j++) {
                        //G[j]是产生式A→α
                        if (A.equals(G.get(j)) && A.getProdRight().equals(G.get(j).getProdRight())) {
                            //∀a∈FOLLOW(A)
                            for (Word a : FOLLOW.get(A)) {
                                //ACTION[ i, a ]＝rj
                                table.getACTION()[i].put(a, new ParseTable.A_i("r", j));
                            }
                            break;
                        }
                    }
                }
                //S'→S·
                else {
                    //ACTION[i , #]=acc
                    table.getACTION()[i].put(new Word(WD.END), new ParseTable.A_i("acc", -1));
                }
            }
        }
    }

    /**
     * SLR(1)语法分析
     *
     * @param wordList 终结符列表
     * @return boolean
     * @author 李电楠
     */
    public boolean parse(ArrayList<Word> wordList) {
        Stack<Integer> state = new Stack<>(); //状态栈
        Stack<Char> charStack = new Stack<>(); //符号栈
        state.push(0);
        Word a;
        for (int w = 0; w < wordList.size(); ) { //枚举所有的word
            a = wordList.get(w);
            //s是栈顶的状态
            int s = state.peek();
            //i＝ACTION[s，a]
            ParseTable.A_i i = table.getACTION()[s].get(a); //看一下从s向a的转移
            //i不存在，即error
            if (i == null) {
                break;
            }
            //i＝st，移进操作
            else if (i.getL().equals("s")) {
                //将t压入栈中
                state.push(i.getR());
                charStack.push(a);
                //a往后移动一个
                w++;
            }
            //i＝rt，归约操作
            else if (i.getL().equals("r")) {
                //归约A→β，也就是将栈中的β变为A
                NTChar A = G.get(i.getR()); //用A这个产生式进行归约
                //从栈中弹出│β│个符号，
                for (int j = 0; j < A.getProdRight().size(); j++) {
                    state.pop();
                    charStack.pop();
                }
                //将GOTO[栈顶，A]压入栈中
                charStack.push(A);
                state.push(table.getGOTO()[state.peek()].get(A).getR());
                //打印产生式A→β
                System.out.print(A.getMy_type().toString() + "->");
                for (Char c : A.getProdRight()) {
                    System.out.print(c.getMy_type().toString() + " ");
                }
                System.out.println();
            }
            //i＝acc，结束符号
            else if (i.getL().equals("acc")) {
                return true;
            }
            //打印文法符号栈
            for (Char aChar : charStack) {
                System.out.print(aChar.getMy_type().toString() + " ");
            }
            System.out.println();
        }
        return false;
    }

    public void printInfo() {
        //打印文法
        System.out.println("文法：");
        for (int i = 0; i < G.size(); i++) {
            System.out.print("P" + i + " " + G.get(i).getMy_type().toString() + "->");
            for (Char aChar : G.get(i).getProdRight()) {
                System.out.print(aChar.getMy_type().toString()+ " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
        //打印项目集族
        System.out.println("项目集族：");
        int t = 0;
        for (LinkedHashSet<Item> items : C) {
            System.out.println("I" + t + ":");
            for (Item item : items) {
                int pos = 0;
                System.out.print(item.getLeftChar().getMy_type().toString() + "->");
                for (Char aChar : item.getLeftChar().getProdRight()) {
                    if (pos == item.getPointPos()) System.out.print("·");
                    System.out.print(aChar.getMy_type().toString() + " ");
                    pos++;
                }
                if (pos == item.getPointPos()) System.out.print("·");
                System.out.println();
            }
            t++;
        }
        System.out.println("--------------------------------------------------------------------------------");
        //打印FIRST集
        System.out.println("FIRST集：");
        FIRST.forEach((aChar, chars) -> {
            System.out.println(aChar.getMy_type().toString() + ":");
            chars.forEach(aChar1 -> System.out.print(aChar1.getMy_type().toString() + " "));
            System.out.println();
        });
        System.out.println("--------------------------------------------------------------------------------");
        //打印FOLLOW集
        System.out.println("FOLLOW集：");
        FOLLOW.forEach((aChar, chars) -> {
            System.out.println(aChar.getMy_type().toString() + ":");
            chars.forEach(aChar1 -> System.out.print(aChar1.getMy_type().toString() + " "));
            System.out.println();
        });
        System.out.println("--------------------------------------------------------------------------------");
        //打印ACTION表
        System.out.println("ACTION表：");
        for (int i = 0; i < table.getACTION().length; i++) {
            System.out.print("s" + i + " ");
            table.getACTION()[i].forEach((x, tChar) -> System.out.print(x.getMy_type().toString() + " " + tChar.getL() + tChar.getR() + "|||"));
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
        //打印GOTO表
        System.out.println("GOTO表：");
        for (int i = 0; i < table.getGOTO().length; i++) {
            System.out.print("s" + i + " ");
            table.getGOTO()[i].forEach((x, tChar) -> System.out.print(x.getMy_type().toString() + " " + tChar.getR() + "|||"));
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
