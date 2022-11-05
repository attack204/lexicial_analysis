package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class RETURN extends Word {
    public RETURN() {
        type = Types.RETURN;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.RETURN);
        return this;
    }
}
