package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class GREATER extends Word {
    public GREATER() {
        type = Types.GREATER;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.GREATER);
        return this;
    }
}
