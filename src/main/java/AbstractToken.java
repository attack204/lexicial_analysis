import lombok.Getter;

//文法符号
public abstract class AbstractToken {
    //是否为终结符
    @Getter
    protected boolean isEndToken;

    public AbstractToken() {
        setEndToken();
    }

    public abstract WD getMy_type();

    /**
     * 设置isTerminal
     */
    protected abstract void setEndToken();

    //判断两文法符号是否属于同一类

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        AbstractToken newo = (AbstractToken) o;
        return getMy_type() == newo.getMy_type();
    }

    //使同一文法符号类的不同对象哈希值相同

    @Override
    public int hashCode() {
        return getMy_type().hashCode();
    }
}
