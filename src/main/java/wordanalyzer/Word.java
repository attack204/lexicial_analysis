package wordanalyzer;

import grammar.Char;
import lombok.Getter;
import lombok.ToString;
import wordanalyzer.words.WD;

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
     * @return wordanalyzer.Word
     * @author 李电楠
     */

    /*
    ADD,
    ANNOTATION,
    ASSIGN,
    BOOL,
    BOOL_VALUE,
    BREAK,
    CONTINUE,
    DIVIDE,
    DKH_L,
    DKH_R,
    ELSE,
    END,
    EQUAL,
    FLOAT,
    FLOAT_VALUE,
    GENERATE,
    GENERATE_EQUAL,
    ID,
    IF,
    INT,
    INT_VALUE,
    LESS,
    LESS_EQUAL,
    MAIN,
    MULTIPLY,
    OTHER,
    OTHER_ID,
    RETURN,
    SEMICOLON,
    SPACE,
    STRING,
    STRING_VALUE,
    SUBTRACT,
    WHILE,
    XKH_L,
    XKH_R,
    ZKH_L,
    ZKH_R,
     */
    public Word makePattern(WD wd) {
        if(wd == WD.ADD) {
            pattern = Pattern.compile(Patterns.ADD);
        }
        if(wd == WD.ANNOTATION) {
            pattern = Pattern.compile(Patterns.ANNOTATION);
        }
        if(wd == WD.ASSIGN) {
            pattern = Pattern.compile(Patterns.ASSIGN);
        }
        if(wd == WD.BOOL) {
            pattern = Pattern.compile(Patterns.BOOL);
        }
        if(wd == WD.BOOL_VALUE) {
            pattern = Pattern.compile(Patterns.BOOL_VALUE);
        }
        if(wd == WD.BREAK) {
            pattern = Pattern.compile(Patterns.BREAK);
        }
        if(wd == WD.CONTINUE) {
            pattern = Pattern.compile(Patterns.CONTINUE);
        }
        if(wd == WD.DIVIDE) {
            pattern = Pattern.compile(Patterns.DIVIDE);
        }
        if(wd == WD.DKH_L) {
            pattern = Pattern.compile(Patterns.DKH_L);
        }
        if(wd == WD.DKH_R) {
            pattern = Pattern.compile(Patterns.DKH_R);
        }
        if(wd == WD.ELSE) {
            pattern = Pattern.compile(Patterns.ELSE);
        }
        if(wd == WD.END) {
            pattern = Pattern.compile(Patterns.END);
        }
        if(wd == WD.EQUAL) {
            pattern = Pattern.compile(Patterns.EQUAL);
        }
        if(wd == WD.FLOAT) {
            pattern = Pattern.compile(Patterns.FLOAT);
        }
        if(wd == WD.FLOAT_VALUE) {
            pattern = Pattern.compile(Patterns.FLOAT_VALUE);
        }
        if(wd == WD.GREATER) {
            pattern = Pattern.compile(Patterns.GREATER);
        }
        if(wd == WD.GREATER_EQUAL) {
            pattern = Pattern.compile(Patterns.GREATER_EQUAL);
        }
        if(wd == WD.ID) {
            pattern = Pattern.compile(Patterns.ID);
        }
        if(wd == WD.IF) {
            pattern = Pattern.compile(Patterns.IF);
        }
        if(wd == WD.INT) {
            pattern = Pattern.compile(Patterns.INT);
        }
        if(wd == WD.INT_VALUE) {
            pattern = Pattern.compile(Patterns.INT_VALUE);
        }
        if(wd == WD.LESS) {
            pattern = Pattern.compile(Patterns.LESS);
        }
        if(wd == WD.LESS_EQUAL) {
            pattern = Pattern.compile(Patterns.LESS_EQUAL);
        }
        if(wd == WD.MAIN) {
            pattern = Pattern.compile(Patterns.MAIN);
        }
        if(wd == WD.MULTIPLY) {
            pattern = Pattern.compile(Patterns.MULTIPLY);
        }
        if(wd == WD.OTHER) {
            pattern = Pattern.compile(Patterns.OTHER);
        }
        if(wd == WD.OTHER_ID) {
            pattern = Pattern.compile(Patterns.OTHER_ID);
        }
        if(wd == WD.RETURN) {
            pattern = Pattern.compile(Patterns.RETURN);
        }
        if(wd == WD.SEMICOLON) {
            pattern = Pattern.compile(Patterns.SEMICOLON);
        }
        if(wd == WD.SPACE) {
            pattern = Pattern.compile(Patterns.SPACE);
        }
        if(wd == WD.STRING) {
            pattern = Pattern.compile(Patterns.STRING);
        }
        if(wd == WD.STRING_VALUE) {
            pattern = Pattern.compile(Patterns.STRING_VALUE);
        }
        if(wd == WD.SUBTRACT) {
            pattern = Pattern.compile(Patterns.SUBTRACT);
        }
        if(wd == WD.WHILE) {
            pattern = Pattern.compile(Patterns.WHILE);
        }
        if(wd == WD.XKH_L) {
            pattern = Pattern.compile(Patterns.XKH_L);
        }
        if(wd == WD.XKH_R) {
            pattern = Pattern.compile(Patterns.XKH_R);
        }
        if(wd == WD.ZKH_L) {
            pattern = Pattern.compile(Patterns.ZKH_L);
        }
        if(wd == WD.ZKH_R) {
            pattern = Pattern.compile(Patterns.ZKH_R);
        }
        if(wd == WD.NOTEQUAL) {
            pattern = Pattern.compile(Patterns.NOTEQUAL);
        }


        return this;
    }

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
