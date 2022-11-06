import lombok.Getter;

//文法符号
public abstract class AbstractToken {
    //是否为终结符
    @Getter
    protected boolean isTerminal;

    public AbstractToken() {
        setIsTerminal();
    }
    public abstract WD getMy_type();

    /**
     * 设置isTerminal
     */
    protected abstract void setIsTerminal();

    /**
     * 重写
     * 判断两文法符号是否属于同一类
     *
     * @param o 文法符号
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //return getClass().isInstance(o);
        AbstractToken newo = (AbstractToken) o;
        return getMy_type() == newo.getMy_type();
    }

    /**
     * 重写
     * 使同一文法符号类的不同对象哈希值相同
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
