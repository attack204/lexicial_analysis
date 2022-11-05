package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class MULTIPLY extends Word {
    public MULTIPLY() {
        type = Types.MULTIPLY;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.MULTIPLY);
        return this;
    }
}
