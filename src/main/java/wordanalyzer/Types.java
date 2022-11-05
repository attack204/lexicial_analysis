package wordanalyzer;

//种别码
public class Types {
    public static final int OTHER = -1;
    public static final int ID = 0;
    public static final int FLOAT_VALUE = 1;
    public static final int INT_VALUE = 2;
    public static final int STRING_VALUE = 3;
    public static final int BOOL_VALUE = 4;
    //关键字
    public static final int FLOAT = 5;
    public static final int INT = 6;
    public static final int STRING = 7;
    public static final int BOOL = 8;
    public static final int IF = 9;
    public static final int ELSE = 10;
    public static final int WHILE = 11;
    public static final int CONTINUE = 12;
    public static final int BREAK = 13;
    public static final int MAIN = 14;
    public static final int RETURN = 15;
    //分隔符
    public static final int SPACE = 16;
    public static final int XKH_L = 17;
    public static final int XKH_R = 18;
    public static final int ZKH_L = 19;
    public static final int ZKH_R = 20;
    public static final int DKH_L = 21;
    public static final int DKH_R = 22;
    public static final int SEMICOLON = 23;
    //运算符
    public static final int ADD = 24;
    public static final int SUBTRACT = 25;
    public static final int MULTIPLY = 26;
    public static final int DIVIDE = 27;
    //注释
    public static final int ANNOTATION = 28;
    //赋值
    public static final int ASSIGN = 29;
    //判断
    public static final int GREATER_EQUAL = 30;
    public static final int LESS_EQUAL = 31;
    public static final int GREATER = 32;
    public static final int LESS = 33;
    public static final int EQUAL = 34;
    public static final int NOTEQUAL = 35;
    //#
    public static final int END = 36;
}
