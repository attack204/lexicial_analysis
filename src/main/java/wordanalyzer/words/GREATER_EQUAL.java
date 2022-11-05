package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class GREATER_EQUAL extends Word {
    public GREATER_EQUAL() {
        type = Types.GREATER_EQUAL;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.GREATER_EQUAL);
        return this;
    }
}
