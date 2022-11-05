package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class SUBTRACT extends Word {
    public SUBTRACT() {
        type = Types.SUBTRACT;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.SUBTRACT);
        return this;
    }
}
