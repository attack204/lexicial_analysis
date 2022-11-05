package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ZKH_R extends Word {
    public ZKH_R() {
        type = Types.ZKH_R;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ZKH_R);
        return this;
    }
}
