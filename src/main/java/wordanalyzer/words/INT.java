package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class INT extends Word {
    public INT() {
        type = Types.INT;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.INT);
        return this;
    }
}
