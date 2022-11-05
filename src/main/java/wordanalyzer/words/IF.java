package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class IF extends Word {
    public IF() {
        type = Types.IF;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.IF);
        return this;
    }
}
