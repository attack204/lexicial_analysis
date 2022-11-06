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
        //type = my_type.hashCode();
        if(wd_ == WD.ADD) {
            type = Types.ADD;
        }
        else if(wd_ == WD.ANNOTATION) {
            type = Types.ANNOTATION;
        }
        else if(wd_ == WD.ASSIGN) {
            type = Types.ASSIGN;
        }
        else if(wd_ == WD.BOOL) {
            type = Types.BOOL;
        }
        else if(wd_ == WD.BOOL_VALUE) {
            type = Types.BOOL_VALUE;
        }
        else if(wd_ == WD.BREAK) {
            type = Types.BREAK;
        }
        else if(wd_ == WD.CONTINUE) {
            type = Types.CONTINUE;
        }
        else if(wd_ == WD.DIVIDE) {
            type = Types.DIVIDE;
        }
        else if(wd_ == WD.DKH_L) {
            type = Types.DKH_L;
        }
        else if(wd_ == WD.DKH_R) {
            type = Types.DKH_R;
        }
        else if(wd_ == WD.ELSE) {
            type = Types.ELSE;
        }
        else if(wd_ == WD.END) {
            type = Types.END;
        }
        else if(wd_ == WD.EQUAL) {
            type = Types.EQUAL;
        }
        else if(wd_ == WD.FLOAT) {
            type = Types.FLOAT;
        }
        else if(wd_ == WD.FLOAT_VALUE) {
            type = Types.FLOAT_VALUE;
        }
        else if(wd_ == WD.GREATER) {
            type = Types.GREATER;
        }
        else if(wd_ == WD.GREATER_EQUAL) {
            type = Types.GREATER_EQUAL;
        }
        else if(wd_ == WD.ID) {
            type = Types.ID;
        }
        else if(wd_ == WD.IF) {
            type = Types.IF;
        }
        else if(wd_ == WD.INT) {
            type = Types.INT;
        }
        else if(wd_ == WD.INT_VALUE) {
            type = Types.INT_VALUE;
        }
        else if(wd_ == WD.LESS) {
            type = Types.LESS;
        }
        else if(wd_ == WD.LESS_EQUAL) {
            type = Types.LESS_EQUAL;
        }
        else if(wd_ == WD.MAIN) {
            type = Types.MAIN;
        }
        else if(wd_ == WD.MULTIPLY) {
            type = Types.MULTIPLY;
        }
        else if(wd_ == WD.OTHER) {
            type = Types.OTHER;
        }
        else if(wd_ == WD.OTHER_ID) {
            type = Types.OTHER;
        }
        else if(wd_ == WD.RETURN) {
            type = Types.RETURN;
        }
        else if(wd_ == WD.SEMICOLON) {
            type = Types.SEMICOLON;
        }
        else if(wd_ == WD.SPACE) {
            type = Types.SPACE;
        }
        else if(wd_ == WD.STRING) {
            type = Types.STRING;
        }
        else if(wd_ == WD.STRING_VALUE) {
            type = Types.STRING_VALUE;
        }
        else if(wd_ == WD.SUBTRACT) {
            type = Types.SUBTRACT;
        }
        else if(wd_ == WD.WHILE) {
            type = Types.WHILE;
        }
        else if(wd_ == WD.XKH_L) {
            type = Types.XKH_L;
        }
        else if(wd_ == WD.XKH_R) {
            type = Types.XKH_R;
        }
        else if(wd_ == WD.ZKH_L) {
            type = Types.ZKH_L;
        }
        else if(wd_ == WD.ZKH_R) {
            type = Types.ZKH_R;
        }

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
