package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ANNOTATION extends Word {
    public ANNOTATION() {
        type = Types.ANNOTATION;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ANNOTATION);
        return this;
    }
}
