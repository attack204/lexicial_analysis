package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class ZKH_L extends Word {
    public ZKH_L() {
        type = Types.ZKH_L;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.ZKH_L);
        return this;
    }
}
