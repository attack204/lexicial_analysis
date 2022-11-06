import lombok.Getter;

import java.util.ArrayList;

//正则匹配顺序
public class AnalyzeOrder {
    //终结符匹配顺序列表
    @Getter
    private static final ArrayList<Token> Tokens = new ArrayList<>();

    static {
        Tokens.add(new Token(WD.ANNOTATION).makePattern(WD.ANNOTATION));
        Tokens.add(new Token(WD.OTHER_ID).makePattern(WD.OTHER_ID));
        Tokens.add(new Token(WD.FLOAT_VALUE).makePattern(WD.FLOAT_VALUE));
        Tokens.add(new Token(WD.INT_VALUE).makePattern(WD.INT_VALUE));
        Tokens.add(new Token(WD.STRING_VALUE).makePattern(WD.STRING_VALUE));
        Tokens.add(new Token(WD.BOOL_VALUE).makePattern(WD.BOOL_VALUE));
        Tokens.add(new Token(WD.FLOAT).makePattern(WD.FLOAT));
        Tokens.add(new Token(WD.INT).makePattern(WD.INT));
        Tokens.add(new Token(WD.STRING).makePattern(WD.STRING));
        Tokens.add(new Token(WD.BOOL).makePattern(WD.BOOL));
        Tokens.add(new Token(WD.IF).makePattern(WD.IF));
        Tokens.add(new Token(WD.ELSE).makePattern(WD.ELSE));
        Tokens.add(new Token(WD.WHILE).makePattern(WD.WHILE));
        Tokens.add(new Token(WD.CONTINUE).makePattern(WD.CONTINUE));
        Tokens.add(new Token(WD.BREAK).makePattern(WD.BREAK));
        Tokens.add(new Token(WD.MAIN).makePattern(WD.MAIN));
        Tokens.add(new Token(WD.RETURN).makePattern(WD.RETURN));
        Tokens.add(new Token(WD.SPACE).makePattern(WD.SPACE));
        Tokens.add(new Token(WD.XKH_L).makePattern(WD.XKH_L));
        Tokens.add(new Token(WD.XKH_R).makePattern(WD.XKH_R));
        Tokens.add(new Token(WD.ZKH_L).makePattern(WD.ZKH_L));
        Tokens.add(new Token(WD.ZKH_R).makePattern(WD.ZKH_R));
        Tokens.add(new Token(WD.DKH_L).makePattern(WD.DKH_L));
        Tokens.add(new Token(WD.DKH_R).makePattern(WD.DKH_R));
        Tokens.add(new Token(WD.SEMICOLON).makePattern(WD.SEMICOLON));
        Tokens.add(new Token(WD.ADD).makePattern(WD.ADD));
        Tokens.add(new Token(WD.SUBTRACT).makePattern(WD.SUBTRACT));
        Tokens.add(new Token(WD.MULTIPLY).makePattern(WD.MULTIPLY));
        Tokens.add(new Token(WD.DIVIDE).makePattern(WD.DIVIDE));
        Tokens.add(new Token(WD.GREATER_EQUAL).makePattern(WD.GREATER_EQUAL));
        Tokens.add(new Token(WD.LESS_EQUAL).makePattern(WD.LESS_EQUAL));
        Tokens.add(new Token(WD.GREATER).makePattern(WD.GREATER));
        Tokens.add(new Token(WD.LESS).makePattern(WD.LESS));
        Tokens.add(new Token(WD.EQUAL).makePattern(WD.EQUAL));
        Tokens.add(new Token(WD.NOTEQUAL).makePattern(WD.NOTEQUAL));
        Tokens.add(new Token(WD.ASSIGN).makePattern(WD.ASSIGN));
        Tokens.add(new Token(WD.ID).makePattern(WD.ID));
        Tokens.add(new Token(WD.OTHER).makePattern(WD.OTHER));
    }
}
