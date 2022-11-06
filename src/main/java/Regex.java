import java.util.HashMap;
import java.util.Map;

//正则表达式
public  class Regex {

    public static Map<String, String> pat;
    static {
        pat = new HashMap<>();
        pat.put("OTHER", ".");
        pat.put("OTHER_ID", "\\d+[A-Za-z_]+");
        pat.put("ID", "[A-Za-z]\\w*");
        pat.put("FLOAT_VALUE", "\\d+\\.\\d+");
        pat.put("INT_VALUE", "\\d+");
        pat.put("STRING_VALUE", "\".*\"");
        pat.put("BOOL_VALUE", "false|true");
        //关键字
        pat.put("FLOAT", "float");
        pat.put("INT", "int");
        pat.put("STRING", "string");
        pat.put("BOOL", "bool");
        pat.put("IF", "if");
        pat.put("ELSE", "else");
        pat.put("WHILE", "while");
        pat.put("CONTINUE", "continue");
        pat.put("BREAK", "break");
        pat.put("MAIN", "main");
        pat.put("RETURN", "return");
        //分隔符
        pat.put("SPACE", "\\s+");
        pat.put("XKH_L", "\\(");
        pat.put("XKH_R", "\\)");
        pat.put("ZKH_L", "\\[");
        pat.put("ZKH_R", "\\]");
        pat.put("DKH_L", "\\{");
        pat.put("DKH_R", "\\}");
        pat.put("SEMICOLON", ";");
        //运算符
        pat.put("ADD", "\\+");
        pat.put("SUBTRACT", "-");
        pat.put("MULTIPLY", "\\*");
        pat.put("DIVIDE", "/");
        //注释
        pat.put("ANNOTATION", "//.*");
        //赋值
        pat.put("ASSIGN", "=");
        //判断
        pat.put("GREATER_EQUAL", ">=");
        pat.put("LESS_EQUAL", "<=");
        pat.put("GREATER", ">");
        pat.put("LESS", "<");
        pat.put("EQUAL", "==");
        pat.put("NOTEQUAL", "!=");
        //#
        pat.put("END", "#");
    }
    static String find(String key) {
        if(!pat.containsKey(key)) {
            return null;
        } else {
            return pat.get(key);
        }
    }
}
