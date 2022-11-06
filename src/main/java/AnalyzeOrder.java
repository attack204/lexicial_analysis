import lombok.Getter;

import java.util.ArrayList;

//正则匹配顺序
public class AnalyzeOrder {
    //终结符匹配顺序列表
    @Getter
    private static final ArrayList<Word> words = new ArrayList<>();

    static {
        words.add(new Word(WD.ANNOTATION).makePattern(WD.ANNOTATION));
        words.add(new Word(WD.OTHER_ID).makePattern(WD.OTHER_ID));
        words.add(new Word(WD.FLOAT_VALUE).makePattern(WD.FLOAT_VALUE));
        words.add(new Word(WD.INT_VALUE).makePattern(WD.INT_VALUE));
        words.add(new Word(WD.STRING_VALUE).makePattern(WD.STRING_VALUE));
        words.add(new Word(WD.BOOL_VALUE).makePattern(WD.BOOL_VALUE));
        words.add(new Word(WD.FLOAT).makePattern(WD.FLOAT));
        words.add(new Word(WD.INT).makePattern(WD.INT));
        words.add(new Word(WD.STRING).makePattern(WD.STRING));
        words.add(new Word(WD.BOOL).makePattern(WD.BOOL));
        words.add(new Word(WD.IF).makePattern(WD.IF));
        words.add(new Word(WD.ELSE).makePattern(WD.ELSE));
        words.add(new Word(WD.WHILE).makePattern(WD.WHILE));
        words.add(new Word(WD.CONTINUE).makePattern(WD.CONTINUE));
        words.add(new Word(WD.BREAK).makePattern(WD.BREAK));
        words.add(new Word(WD.MAIN).makePattern(WD.MAIN));
        words.add(new Word(WD.RETURN).makePattern(WD.RETURN));
        words.add(new Word(WD.SPACE).makePattern(WD.SPACE));
        words.add(new Word(WD.XKH_L).makePattern(WD.XKH_L));
        words.add(new Word(WD.XKH_R).makePattern(WD.XKH_R));
        words.add(new Word(WD.ZKH_L).makePattern(WD.ZKH_L));
        words.add(new Word(WD.ZKH_R).makePattern(WD.ZKH_R));
        words.add(new Word(WD.DKH_L).makePattern(WD.DKH_L));
        words.add(new Word(WD.DKH_R).makePattern(WD.DKH_R));
        words.add(new Word(WD.SEMICOLON).makePattern(WD.SEMICOLON));
        words.add(new Word(WD.ADD).makePattern(WD.ADD));
        words.add(new Word(WD.SUBTRACT).makePattern(WD.SUBTRACT));
        words.add(new Word(WD.MULTIPLY).makePattern(WD.MULTIPLY));
        words.add(new Word(WD.DIVIDE).makePattern(WD.DIVIDE));
        words.add(new Word(WD.GREATER_EQUAL).makePattern(WD.GREATER_EQUAL));
        words.add(new Word(WD.LESS_EQUAL).makePattern(WD.LESS_EQUAL));
        words.add(new Word(WD.GREATER).makePattern(WD.GREATER));
        words.add(new Word(WD.LESS).makePattern(WD.LESS));
        words.add(new Word(WD.EQUAL).makePattern(WD.EQUAL));
        words.add(new Word(WD.NOTEQUAL).makePattern(WD.NOTEQUAL));
        words.add(new Word(WD.ASSIGN).makePattern(WD.ASSIGN));
        words.add(new Word(WD.ID).makePattern(WD.ID));
        words.add(new Word(WD.OTHER).makePattern(WD.OTHER));
    }
}
