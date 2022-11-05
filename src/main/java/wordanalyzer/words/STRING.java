package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class STRING extends Word {
    public STRING() {
        type = Types.STRING;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.STRING);
        return this;
    }
}
