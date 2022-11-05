package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class END extends Word {
    public END() {
        type = Types.END;
        value = "#";
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.END);
        return this;
    }
}
