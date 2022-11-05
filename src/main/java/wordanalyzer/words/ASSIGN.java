package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ASSIGN extends Word {
    public ASSIGN() {
        type = Types.ASSIGN;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ASSIGN);
        return this;
    }
}
