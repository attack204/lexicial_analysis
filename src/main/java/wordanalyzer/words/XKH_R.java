package wordanalyzer.words;

import wordanalyzer.Patterns;
import wordanalyzer.Types;
import wordanalyzer.Word;

import java.util.regex.Pattern;

public class XKH_R extends Word {
    public XKH_R() {
        type = Types.XKH_R;
    }

    @Override
    public Word makePattern() {
        pattern = Pattern.compile(Patterns.XKH_R);
        return this;
    }
}
