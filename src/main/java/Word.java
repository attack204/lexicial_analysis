import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.regex.Pattern;

//终结符
@ToString
public class Word extends Char {
    @Getter
    @ToString.Exclude
    protected Pattern pattern;

    //种别码
    @Getter
    protected int type;

    protected WD my_type;
    @Override
    public WD getMy_type() {
        return my_type;
    }

    private final ArrayList<Char> prodRight = new ArrayList<>();


    public Word(WD wd_) {
        my_type = wd_;
        type = (wd_ == WD.OTHER_ID ?  WD.OTHER.ordinal() : my_type.ordinal()) - 1;
    }
    //属性值
    @Getter
    protected Object value;

    @Override
    protected void setIsTerminal() {
        isTerminal = true;
    }

    /**
     * 编译正则表达式并赋值给pattern
     * 返回this
     *
     * @return Word
     */

    public Word makePattern(WD wd) {

        pattern = Pattern.compile(Patterns.find(wd.toString()));

        return this;
    }

    /**
     * 设置属性值
     *
     * @param value 匹配到的字符串
     */
    public void setValue(String value) {
        this.value = '"' + value + '"';
    }
}
