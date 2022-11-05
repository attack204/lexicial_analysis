package wordanalyzer;

import grammar.Char;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

//终结符
@ToString
public abstract class Word extends Char {
    @Getter
    @ToString.Exclude
    protected Pattern pattern;

    //种别码
    @Getter
    protected int type;

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
     * @return wordanalyzer.Word
     * @author 李电楠
     */
    public abstract Word makePattern();

    /**
     * 设置属性值
     *
     * @param value 匹配到的字符串
     * @author 李电楠
     */
    public void setValue(String value) {
        this.value = '"' + value + '"';
    }
}
