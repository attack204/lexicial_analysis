package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class LESS_EQUAL extends Word {
    public LESS_EQUAL() {
        type = Types.LESS_EQUAL;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.LESS_EQUAL);
        return this;
    }
}
