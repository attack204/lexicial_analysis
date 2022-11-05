package grammar;

import lombok.Getter;
import wordanalyzer.words.WD;

//文法符号
public abstract class Char {
    //是否为终结符
    @Getter
    protected boolean isTerminal;

    public Char() {
        setIsTerminal();
    }
    public abstract WD getMy_type();

    /**
     * 设置isTerminal
     *
     * @author 李电楠
     */
    protected abstract void setIsTerminal();

    /**
     * 重写
     * 判断两文法符号是否属于同一类
     *
     * @param o 文法符号
     * @return boolean
     * @author 李电楠
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //return getClass().isInstance(o);
        Char newo = (Char) o;
        return getMy_type() == newo.getMy_type();
    }

    /**
     * 重写
     * 使同一文法符号类的不同对象哈希值相同
     *
     * @return int
     * @author 李电楠
     */
    @Override
    public int hashCode() {
        //return getClass().hashCode();
        //return getMy_type().ordinal();
//        return getMy_type().hashCode();
       // return getClass().hashCode() * 10 + getMy_type().hashCode();
        return getMy_type().hashCode();
    }
}
