public class NameSpecification implements Specification {
    @Override
    public boolean isSatisfied(Param p, File f) {
        if (p.name == null || p.name.isEmpty()) return true;
        return f.getName().equalsIgnoreCase(p.name);
    }
}
