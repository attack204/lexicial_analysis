import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//项目
@ToString
@AllArgsConstructor
public class Item {
    //项目左部非终结符
    @Getter
    private final NTChar leftChar;

    //'·'在右部中的位置，即表示已经移进到了哪个位置
    //范围：0 ~ leftChar.getProdRight().size()
    //                             0 即位于最前 e.g. S→O ·
    //leftChar.getProdRight().size() 即位于最后 e.g. S→·O
    @Getter
    private final int pointPos;

    /**
     * 重写
     * 判断两项目是否相同
     *
     * @param o 项目
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!getClass().isInstance(o)) return false;
        Item x = (Item) o;
        return leftChar.equals(x.leftChar) && leftChar.getProdRight().equals(x.leftChar.getProdRight()) && pointPos == x.pointPos;
    }

    /**
     * 使相同的项目哈希值相同
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return leftChar.hashCode() + leftChar.getProdRight().hashCode() + pointPos;
    }
}
