package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class FLOAT_VALUE extends Word {
    public FLOAT_VALUE() {
        type = Types.FLOAT_VALUE;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.FLOAT_VALUE);
        return this;
    }

    @Override
    public void setValue(String value) {
        this.value = Float.parseFloat(value);
    }
}
