public class OrSpecification implements Specification {
    private Specification one;
    private Specification other;

    public OrSpecification(Specification one, Specification other) {
        this.one = one;
        this.other = other;
    }

    @Override
    public boolean isSatisfied(Param p, File f) {
        return one.isSatisfied(p, f) || other.isSatisfied(p, f);
    }
}
