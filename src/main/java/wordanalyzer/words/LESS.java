package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class LESS extends Word {
    public LESS() {
        type = Types.LESS;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.LESS);
        return this;
    }
}
