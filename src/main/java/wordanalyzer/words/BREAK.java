package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class BREAK extends Word {
    public BREAK() {
        type = Types.BREAK;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.BREAK);
        return this;
    }
}
