package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ID extends Word {
    public ID() {
        type = Types.ID;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ID);
        return this;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
