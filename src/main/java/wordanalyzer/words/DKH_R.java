package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class DKH_R extends Word {
    public DKH_R() {
        type = Types.DKH_R;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.DKH_R);
        return this;
    }
}
