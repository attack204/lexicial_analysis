package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class DIVIDE extends Word {
    public DIVIDE() {
        type = Types.DIVIDE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.DIVIDE);
        return this;
    }
}
