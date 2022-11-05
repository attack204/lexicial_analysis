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
