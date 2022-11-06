import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//词法分析器
public class WordAnalyzer {
    //终结符匹配顺序列表
    private final ArrayList<Word> words;

    //分析结果
    private final ArrayList<Word> result = new ArrayList<>();

    public WordAnalyzer() {
        words = AnalyzeOrder.getWords();
    }

    /**
     * 词法分析
     *
     * @param code 源程序
     * @return java.util.ArrayList<Word>
     */
    public ArrayList<Word> analyze(String code) throws Exception {
        int pos = 0;
        while (pos < code.length()) {
            for (Word i : words) {
                Pattern pattern = i.getPattern();
                //正则匹配
                Matcher matcher = pattern.matcher(code);
                //匹配范围
                matcher.region(pos, code.length());
                //lookingAt()会把pos位置的字符作为起点进行匹配
                if (matcher.lookingAt()) {
                    //设置新起点
                    pos = matcher.end();
                    switch (i.getType()) {
                        //碰到其他字符，抛出异常
                        case Types.OTHER:
                            throw new WordAnalyzeException("非法文法符号：" + matcher.group());
                        //碰到是空白字符或注释，跳过
                        case Types.SPACE:
                        case Types.ANNOTATION:
                            break;
                        default:
                            addWordToResult(i, matcher.group());
                    }
                    break;
                }
            }
        }
        //将#加入result中
        result.add(new Word(WD.END));
        return result;
    }

    /**
     * 将终结符加入result中
     *
     * @param origWord 匹配用的Word对象
     * @param value 属性值
     */
    private void addWordToResult(Word origWord, String value) throws Exception {
        Word newWord = new Word(origWord.getMy_type());
        newWord.setValue(value);
        result.add(newWord);
    }
}
