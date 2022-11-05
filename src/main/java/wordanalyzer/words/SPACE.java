package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class SPACE extends Word {
    public SPACE() {
        type = Types.SPACE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.SPACE);
        return this;
    }
}
