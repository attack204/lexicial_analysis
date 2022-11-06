import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String fileName = "/Users/liugaoji/Desktop/lexical/output.txt";
        try {
            System.setOut(new PrintStream(new FileOutputStream(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //从resources中获取输入的文件
        URL url = Main.class.getResource("code.txt");
        //初始化词法分析类
        LexicalAalyzer LexicalAalyzer = new LexicalAalyzer();
        //初始化语法分析类
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
        syntaxAnalyzer.printInfo();
        try {
            //从文件中读取源程序
            File codeFile = new File(url.toURI());
            byte[] codeBytes = new byte[(int) codeFile.length()];
            FileInputStream inputStream = new FileInputStream(codeFile);
            if (inputStream.read(codeBytes) != -1) {
                String code = new String(codeBytes);
                System.out.println("源程序：");
                System.out.println(code);
                System.out.println("--------------------------------------------------------------------------------");
                //调用词法分析API进行词法分析
                ArrayList<EndToken> endTokenList = LexicalAalyzer.analyze(code);
                System.out.println("词法分析：");
                for (EndToken EndToken : endTokenList) {
                    System.out.println("<" + EndToken.getMy_type().toString() + "> " + EndToken);
                }
                System.out.println("--------------------------------------------------------------------------------");
                //SLR(1)语法分析
                System.out.println("SLR(1)语法分析：");
                System.out.println(syntaxAnalyzer.parse(endTokenList) ? "语法正确" : "语法错误");
                System.out.println("--------------------------------------------------------------------------------");
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
