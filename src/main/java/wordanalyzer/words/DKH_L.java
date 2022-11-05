package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class DKH_L extends Word {
    public DKH_L() {
        type = Types.DKH_L;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.DKH_L);
        return this;
    }
}
