package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ADD extends Word {
    public ADD() {
        type = Types.ADD;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ADD);
        return this;
    }
}
