package wordanalyzer;

import lombok.Getter;
import wordanalyzer.words.*;

import java.util.ArrayList;

//正则匹配顺序
public class AnalyzeOrder {
    //终结符匹配顺序列表
    @Getter
    private static final ArrayList<Word> words = new ArrayList<>();

    static {
        words.add(new ANNOTATION().makePattern());
        words.add(new OTHER_ID().makePattern());
        words.add(new FLOAT_VALUE().makePattern());
        words.add(new INT_VALUE().makePattern());
        words.add(new STRING_VALUE().makePattern());
        words.add(new BOOL_VALUE().makePattern());
        words.add(new FLOAT().makePattern());
        words.add(new INT().makePattern());
        words.add(new STRING().makePattern());
        words.add(new BOOL().makePattern());
        words.add(new IF().makePattern());
        words.add(new ELSE().makePattern());
        words.add(new WHILE().makePattern());
        words.add(new CONTINUE().makePattern());
        words.add(new BREAK().makePattern());
        words.add(new MAIN().makePattern());
        words.add(new RETURN().makePattern());
        words.add(new SPACE().makePattern());
        words.add(new XKH_L().makePattern());
        words.add(new XKH_R().makePattern());
        words.add(new ZKH_L().makePattern());
        words.add(new ZKH_R().makePattern());
        words.add(new DKH_L().makePattern());
        words.add(new DKH_R().makePattern());
        words.add(new SEMICOLON().makePattern());
        words.add(new ADD().makePattern());
        words.add(new SUBTRACT().makePattern());
        words.add(new MULTIPLY().makePattern());
        words.add(new DIVIDE().makePattern());
        words.add(new GREATER_EQUAL().makePattern());
        words.add(new LESS_EQUAL().makePattern());
        words.add(new GREATER().makePattern());
        words.add(new LESS().makePattern());
        words.add(new EQUAL().makePattern());
        words.add(new NOTEQUAL().makePattern());
        words.add(new ASSIGN().makePattern());
        words.add(new ID().makePattern());
        words.add(new OTHER().makePattern());
    }
}
