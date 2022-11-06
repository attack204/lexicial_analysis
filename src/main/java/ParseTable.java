import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

//SLR(1)分析表
@Data
public class ParseTable {
    //ACTION表
    private HashMap<Word, A_i>[] ACTION;

    //GOTO表
    private HashMap<NTChar, G_i>[] GOTO;

    //ACTION表中的项 e.g. s1
    //s 表示移进操作
    //r 表示归约操作
    @Data
    @AllArgsConstructor
    static class A_i {
        //e.g. "s"
        private String l;

        //e.g. 1
        private int r;
    }

    //GOTO表中的项 e.g. 1
    @Data
    @AllArgsConstructor
    static class G_i {
        //e.g. 1，r代表了第几个产生式
        private int r;
    }
}
