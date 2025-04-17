public class MaxSizeSpecification implements Specification {
    @Override
    public boolean isSatisfied(Param p, File f) {
        return f.getSize() <= p.maxSize;
    }
}
