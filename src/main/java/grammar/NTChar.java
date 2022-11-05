package grammar;

import lombok.Getter;
import lombok.ToString;
import wordanalyzer.WD;

import java.util.ArrayList;

//非终结符（可看作产生式左部）
//这个定义非常的秒，定义了NTChar类继承自Char类，并维护了right集合，这样就能表示产生式了
//A->B/C//D
@ToString
public class NTChar extends Char {
    //产生式右部

    public NTChar(WD wd) {
        my_type = wd;
    }
    @Getter
    private final ArrayList<Char> prodRight = new ArrayList<>();

    @Override
    public WD getMy_type() {
        return my_type;
    }
    private WD my_type;

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
