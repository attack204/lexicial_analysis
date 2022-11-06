import lombok.Getter;

import java.util.ArrayList;

//正则匹配顺序
public class AnalyzeOrder {
    //终结符匹配顺序列表
    @Getter
    private static final ArrayList<EndToken> END_TOKENS = new ArrayList<>();

    static {
//        for (WD wd : WD.values()) {
//            System.out.println(wd.toString());
//            if(Regex.find(wd.toString()) != null) {
//                END_TOKENS.add(new EndToken(wd).makePattern(wd));
//            }
//        }
        END_TOKENS.add(new EndToken(WD.ANNOTATION).makePattern(WD.ANNOTATION));
        END_TOKENS.add(new EndToken(WD.OTHER_ID).makePattern(WD.OTHER_ID));
        END_TOKENS.add(new EndToken(WD.FLOAT_VALUE).makePattern(WD.FLOAT_VALUE));
        END_TOKENS.add(new EndToken(WD.INT_VALUE).makePattern(WD.INT_VALUE));
        END_TOKENS.add(new EndToken(WD.STRING_VALUE).makePattern(WD.STRING_VALUE));
        END_TOKENS.add(new EndToken(WD.BOOL_VALUE).makePattern(WD.BOOL_VALUE));
        END_TOKENS.add(new EndToken(WD.FLOAT).makePattern(WD.FLOAT));
        END_TOKENS.add(new EndToken(WD.INT).makePattern(WD.INT));
        END_TOKENS.add(new EndToken(WD.STRING).makePattern(WD.STRING));
        END_TOKENS.add(new EndToken(WD.BOOL).makePattern(WD.BOOL));
        END_TOKENS.add(new EndToken(WD.IF).makePattern(WD.IF));
        END_TOKENS.add(new EndToken(WD.ELSE).makePattern(WD.ELSE));
        END_TOKENS.add(new EndToken(WD.WHILE).makePattern(WD.WHILE));
        END_TOKENS.add(new EndToken(WD.CONTINUE).makePattern(WD.CONTINUE));
        END_TOKENS.add(new EndToken(WD.BREAK).makePattern(WD.BREAK));
        END_TOKENS.add(new EndToken(WD.MAIN).makePattern(WD.MAIN));
        END_TOKENS.add(new EndToken(WD.RETURN).makePattern(WD.RETURN));
        END_TOKENS.add(new EndToken(WD.SPACE).makePattern(WD.SPACE));
        END_TOKENS.add(new EndToken(WD.XKH_L).makePattern(WD.XKH_L));
        END_TOKENS.add(new EndToken(WD.XKH_R).makePattern(WD.XKH_R));
        END_TOKENS.add(new EndToken(WD.ZKH_L).makePattern(WD.ZKH_L));
        END_TOKENS.add(new EndToken(WD.ZKH_R).makePattern(WD.ZKH_R));
        END_TOKENS.add(new EndToken(WD.DKH_L).makePattern(WD.DKH_L));
        END_TOKENS.add(new EndToken(WD.DKH_R).makePattern(WD.DKH_R));
        END_TOKENS.add(new EndToken(WD.SEMICOLON).makePattern(WD.SEMICOLON));
        END_TOKENS.add(new EndToken(WD.ADD).makePattern(WD.ADD));
        END_TOKENS.add(new EndToken(WD.SUBTRACT).makePattern(WD.SUBTRACT));
        END_TOKENS.add(new EndToken(WD.MULTIPLY).makePattern(WD.MULTIPLY));
        END_TOKENS.add(new EndToken(WD.DIVIDE).makePattern(WD.DIVIDE));
        END_TOKENS.add(new EndToken(WD.GREATER_EQUAL).makePattern(WD.GREATER_EQUAL));
        END_TOKENS.add(new EndToken(WD.LESS_EQUAL).makePattern(WD.LESS_EQUAL));
        END_TOKENS.add(new EndToken(WD.GREATER).makePattern(WD.GREATER));
        END_TOKENS.add(new EndToken(WD.LESS).makePattern(WD.LESS));
        END_TOKENS.add(new EndToken(WD.EQUAL).makePattern(WD.EQUAL));
        END_TOKENS.add(new EndToken(WD.NOTEQUAL).makePattern(WD.NOTEQUAL));
        END_TOKENS.add(new EndToken(WD.ASSIGN).makePattern(WD.ASSIGN));
        END_TOKENS.add(new EndToken(WD.ID).makePattern(WD.ID));
        END_TOKENS.add(new EndToken(WD.OTHER).makePattern(WD.OTHER));
    }
}
