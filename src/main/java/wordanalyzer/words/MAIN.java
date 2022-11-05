package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class MAIN extends Word {
    public MAIN() {
        type = Types.MAIN;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.MAIN);
        return this;
    }
}
