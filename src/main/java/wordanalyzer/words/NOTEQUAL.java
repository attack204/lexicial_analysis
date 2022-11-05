package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class NOTEQUAL extends Word {
    public NOTEQUAL() {
        type = Types.NOTEQUAL;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.NOTEQUAL);
        return this;
    }
}
