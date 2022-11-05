package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class BOOL_VALUE extends Word {
    public BOOL_VALUE() {
        type = Types.BOOL_VALUE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.BOOL_VALUE);
        return this;
    }

    @Override
    public void setValue(String value) {
        this.value = Boolean.parseBoolean(value);
    }
}
