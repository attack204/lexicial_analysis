package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class OTHER extends Word {
    public OTHER() {
        type = Types.OTHER;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.OTHER);
        return this;
    }
}
