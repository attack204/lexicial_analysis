package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class FLOAT extends Word {
    public FLOAT() {
        type = Types.FLOAT;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.FLOAT);
        return this;
    }
}
