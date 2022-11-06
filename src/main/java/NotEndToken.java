import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

//非终结符（可看作产生式左部）
//这个定义非常的秒，定义了NotEndToken类继承自Char类，并维护了right集合，这样就能表示产生式了
//A->B/C//D
@ToString
public class NotEndToken extends AbstractToken {
    //产生式右部

    public NotEndToken(WD wd) {
        my_type = wd;
    }
    @Getter
    private final ArrayList<AbstractToken> prodRight = new ArrayList<>();

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
     * @return NotEndToken
     */
    public NotEndToken a(AbstractToken c) {
        prodRight.add(c);
        return this;
    }
}
