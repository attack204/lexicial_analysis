import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//词法分析器
public class TokenAnalyzer {
    //终结符匹配顺序列表
    private final ArrayList<Token> Tokens;

    //分析结果
    private final ArrayList<Token> result = new ArrayList<>();

    public TokenAnalyzer() {
        Tokens = AnalyzeOrder.getTokens();
    }

    /**
     * 词法分析
     *
     * @param code 源程序
     * @return java.util.ArrayList<Token>
     */
    public ArrayList<Token> analyze(String code) throws Exception {
        int pos = 0;
        while (pos < code.length()) {
            for (Token i : Tokens) {
                Pattern pattern = i.getPattern();
                //正则匹配
                Matcher matcher = pattern.matcher(code);
                //匹配范围
                matcher.region(pos, code.length());
                //lookingAt()会把pos位置的字符作为起点进行匹配
                if (matcher.lookingAt()) {
                    //设置新起点
                    pos = matcher.end();
                    switch (i.getMy_type()) {
                        //碰到其他字符，抛出异常
                        case OTHER:
                            throw new Exception("非法文法符号：" + matcher.group());
                        //碰到是空白字符或注释，跳过
                        case SPACE:
                        case ANNOTATION:
                            break;
                        default:
                            addTokenToResult(i, matcher.group());
                    }
                    break;
                }
            }
        }
        //将#加入result中
        result.add(new Token(WD.END));
        return result;
    }

    /**
     * 将终结符加入result中
     *
     * @param origToken 匹配用的Token对象
     * @param value 属性值
     */
    private void addTokenToResult(Token origToken, String value) throws Exception {
        Token newToken = new Token(origToken.getMy_type());
        newToken.setValue(value);
        result.add(newToken);
    }
}
