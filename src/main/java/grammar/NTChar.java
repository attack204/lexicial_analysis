package grammar;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

//非终结符（可看作产生式左部）
//这个定义非常的秒，定义了NTChar类继承自Char类，并维护了right集合，这样就能表示产生式了
//A->B/C//D
@ToString
public class NTChar extends Char {
    //产生式右部

    @Getter
    private final ArrayList<Char> prodRight = new ArrayList<>();



    @Override
    protected void setIsTerminal() {
        isTerminal = false;
    }

    /**
     * 将c加入产生式右部
     *
     * @param c 文法符号
     * @return grammar.NTChar
     * @author 李电楠
     */
    public NTChar a(Char c) {
        prodRight.add(c);
        return this;
    }
}
