package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class CONTINUE extends Word {
    public CONTINUE() {
        type = Types.CONTINUE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.CONTINUE);
        return this;
    }
}
