package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class BOOL extends Word {
    public BOOL() {
        type = Types.BOOL;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.BOOL);
        return this;
    }
}
