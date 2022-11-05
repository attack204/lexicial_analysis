package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class OTHER_ID extends Word {
    public OTHER_ID() {
        type = Types.OTHER;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.OTHER_ID);
        return this;
    }
}
