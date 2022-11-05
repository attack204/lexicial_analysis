package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class SEMICOLON extends Word {
    public SEMICOLON() {
        type = Types.SEMICOLON;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.SEMICOLON);
        return this;
    }
}
