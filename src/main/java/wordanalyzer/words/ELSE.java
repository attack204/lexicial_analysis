package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ELSE extends Word {
    public ELSE() {
        type = Types.ELSE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ELSE);
        return this;
    }
}
