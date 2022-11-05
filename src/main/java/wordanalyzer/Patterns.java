package wordanalyzer;

//正则表达式
public class Patterns {
    public static final String OTHER = ".";
    public static final String OTHER_ID = "\\d+[A-Za-z_]+";
    public static final String ID = "[A-Za-z]\\w*";
    public static final String FLOAT_VALUE = "\\d+\\.\\d+";
    public static final String INT_VALUE = "\\d+";
    public static final String STRING_VALUE = "\".*\"";
    public static final String BOOL_VALUE = "false|true";
    //关键字
    public static final String FLOAT = "float";
    public static final String INT = "int";
    public static final String STRING = "string";
    public static final String BOOL = "bool";
    public static final String IF = "if";
    public static final String ELSE = "else";
    public static final String WHILE = "while";
    public static final String CONTINUE = "continue";
    public static final String BREAK = "break";
    public static final String MAIN = "main";
    public static final String RETURN = "return";
    //分隔符
    public static final String SPACE = "\\s+";
    public static final String XKH_L = "\\(";
    public static final String XKH_R = "\\)";
    public static final String ZKH_L = "\\[";
    public static final String ZKH_R = "\\]";
    public static final String DKH_L = "\\{";
    public static final String DKH_R = "\\}";
    public static final String SEMICOLON = ";";
    //运算符
    public static final String ADD = "\\+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "\\*";
    public static final String DIVIDE = "/";
    //注释
    public static final String ANNOTATION = "//.*";
    //赋值
    public static final String ASSIGN = "=";
    //判断
    public static final String GREATER_EQUAL = ">=";
    public static final String LESS_EQUAL = "<=";
    public static final String GREATER = ">";
    public static final String LESS = "<";
    public static final String EQUAL = "==";
    public static final String NOTEQUAL = "!=";
    //#
    public static final String END = "#";
}
