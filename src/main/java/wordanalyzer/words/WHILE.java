package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class WHILE extends Word {
    public WHILE() {
        type = Types.WHILE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.WHILE);
        return this;
    }
}
