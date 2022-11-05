package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class STRING_VALUE extends Word {
    public STRING_VALUE() {
        type = Types.STRING_VALUE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.STRING_VALUE);
        return this;
    }

    @Override
    public void setValue(String value) {
        this.value = value.substring(1, value.length() - 1);
    }
}
