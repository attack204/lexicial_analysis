package grammar;

import lombok.Getter;
import wordanalyzer.WD;
import wordanalyzer.Word;

import java.util.ArrayList;
import java.util.LinkedHashSet;

//文法
public class Grammar {
    //产生式
    @Getter
    private static final ArrayList<NTChar> G = new ArrayList<>();

    //文法符号集
    @Getter
    private static final LinkedHashSet<Char> X = new LinkedHashSet<>();

    static {
        //S→O
        G.add(new NTChar(WD.S).a(new NTChar(WD.O)));
        //O→F
        G.add(new NTChar(WD.O).a(new NTChar(WD.F)));
        //O→OF
        G.add(new NTChar(WD.O).a(new NTChar(WD.O)).a(new NTChar(WD.F)));
        //F→TNXA
        G.add(new NTChar(WD.F).a(new NTChar(WD.T)).a(new NTChar(WD.N)).a(new NTChar(WD.X)).a(new NTChar(WD.A)));
        //T→<float>
        G.add(new NTChar(WD.T).a(new Word(WD.FLOAT)));
        //T→<int>
        G.add(new NTChar(WD.T).a(new Word(WD.INT)));
        //T→<string>
        G.add(new NTChar(WD.T).a(new Word(WD.STRING)));
        //T→<bool>
        G.add(new NTChar(WD.T).a(new Word(WD.BOOL)));
        //N→<main>
        G.add(new NTChar(WD.N).a(new Word(WD.MAIN)));
        //N→<ID>
        G.add(new NTChar(WD.N).a(new Word(WD.ID)));
        //X→()
        G.add(new NTChar(WD.X).a(new Word(WD.XKH_L)).a(new Word(WD.XKH_R)));
        //X→(T<ID>)
        G.add(new NTChar(WD.X).a(new Word(WD.XKH_L)).a(new NTChar(WD.T)).a(new Word(WD.ID)).a(new Word(WD.XKH_R)));
        //A→{}
        G.add(new NTChar(WD.A).a(new Word(WD.DKH_L)).a(new Word(WD.DKH_R)));
        //A→{L}
        G.add(new NTChar(WD.A).a(new Word(WD.DKH_L)).a(new NTChar(WD.L)).a(new Word(WD.DKH_R)));
        //L→Y
        G.add(new NTChar(WD.L).a(new NTChar(WD.Y)));
        //L→LY
        G.add(new NTChar(WD.L).a(new NTChar(WD.L)).a(new NTChar(WD.Y)));
        //Y→D
        G.add(new NTChar(WD.Y).a(new NTChar(WD.D)));
        //Y→Z
        G.add(new NTChar(WD.Y).a(new NTChar(WD.Z)));
        //Y→I
        G.add(new NTChar(WD.Y).a(new NTChar(WD.I)));
        //Y→W
        G.add(new NTChar(WD.Y).a(new NTChar(WD.W)));
        //Y→R
        G.add(new NTChar(WD.Y).a(new NTChar(WD.R)));
        //D→T<ID><;>
        G.add(new NTChar(WD.D).a(new NTChar(WD.T)).a(new Word(WD.ID)).a(new Word(WD.SEMICOLON)));
        //Z→B
        G.add(new NTChar(WD.Z).a(new NTChar(WD.B)));
        //Z→TB
        G.add(new NTChar(WD.Z).a(new NTChar(WD.T)).a(new NTChar(WD.B)));
        //B→<ID>=E<;>
        G.add(new NTChar(WD.B).a(new Word(WD.ID)).a(new Word(WD.ASSIGN)).a(new NTChar(WD.E)).a(new Word(WD.SEMICOLON)));
        //E→(E)
        G.add(new NTChar(WD.E).a(new Word(WD.XKH_L)).a(new NTChar(WD.E)).a(new Word(WD.XKH_R)));
        //E→V
        G.add(new NTChar(WD.E).a(new NTChar(WD.V)));
        //E→EGE
        G.add(new NTChar(WD.E).a(new NTChar(WD.E)).a(new NTChar(WD.G)).a(new NTChar(WD.E)));
        //V→<ID>
        G.add(new NTChar(WD.V).a(new Word(WD.ID)));
        //V→C
        G.add(new NTChar(WD.V).a(new NTChar(WD.C)));
        //C→<float_value>
        G.add(new NTChar(WD.C).a(new Word(WD.FLOAT_VALUE)));
        //C→<int_value>
        G.add(new NTChar(WD.C).a(new Word(WD.INT_VALUE)));
        //C→<string_value>
        G.add(new NTChar(WD.C).a(new Word(WD.STRING_VALUE)));
        //C→<bool_value>
        G.add(new NTChar(WD.C).a(new Word(WD.BOOL_VALUE)));
        //G→+
        G.add(new NTChar(WD.G).a(new Word(WD.ADD)));
        //G→-
        G.add(new NTChar(WD.G).a(new Word(WD.SUBTRACT)));
        //G→*
        G.add(new NTChar(WD.G).a(new Word(WD.MULTIPLY)));
        //G→/
        G.add(new NTChar(WD.G).a(new Word(WD.DIVIDE)));
        //I→J
        G.add(new NTChar(WD.I).a(new NTChar(WD.J)));
        //I→K
        G.add(new NTChar(WD.I).a(new NTChar(WD.K)));
        //J→<if>(P)A
        G.add(new NTChar(WD.J).a(new Word(WD.IF)).a(new Word(WD.XKH_L)).a(new NTChar(WD.P)).a(new Word(WD.XKH_R)).a(new NTChar(WD.A)));
        //K→J<else>A
        G.add(new NTChar(WD.K).a(new NTChar(WD.J)).a(new Word(WD.ELSE)).a(new NTChar(WD.A)));
        //P→VQV
        G.add(new NTChar(WD.P).a(new NTChar(WD.V)).a(new NTChar(WD.Q)).a(new NTChar(WD.V)));
        //Q→>
        G.add(new NTChar(WD.Q).a(new Word(WD.GREATER_EQUAL)));
        //Q→<
        G.add(new NTChar(WD.Q).a(new Word(WD.LESS_EQUAL)));
        //Q→>=
        G.add(new NTChar(WD.Q).a(new Word(WD.GREATER)));
        //Q→<=
        G.add(new NTChar(WD.Q).a(new Word(WD.LESS)));
        //Q→==
        G.add(new NTChar(WD.Q).a(new Word(WD.EQUAL)));
        //Q→!=
        G.add(new NTChar(WD.Q).a(new Word(WD.NOTEQUAL)));
        //W→<while>(P)A
        G.add(new NTChar(WD.W).a(new Word(WD.WHILE)).a(new Word(WD.XKH_L)).a(new NTChar(WD.P)).a(new Word(WD.XKH_R)).a(new NTChar(WD.A)));
        //R→<return>V<;>
        G.add(new NTChar(WD.R).a(new Word(WD.RETURN)).a(new NTChar(WD.V)).a(new Word(WD.SEMICOLON)));
        //动态生成文法符号集
        for (NTChar i : G) {
            X.add(i);
            X.addAll(i.getProdRight());
        }
    }
}
