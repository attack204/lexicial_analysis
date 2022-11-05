package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class EQUAL extends Word {
    public EQUAL() {
        type = Types.EQUAL;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.EQUAL);
        return this;
    }
}
