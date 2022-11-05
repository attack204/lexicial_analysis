package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class XKH_L extends Word {
    public XKH_L() {
        type = Types.XKH_L;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.XKH_L);
        return this;
    }
}
