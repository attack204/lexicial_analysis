package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class INT_VALUE extends Word {
    public INT_VALUE() {
        type = Types.INT_VALUE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.INT_VALUE);
        return this;
    }

    @Override
    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }
}
