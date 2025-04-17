public class ExtensionSpecification implements Specification {
    @Override
    public boolean isSatisfied(Param p, File f) {
        if (p.extension == null || p.extension.isEmpty()) return true;
        return f.getExtension().equalsIgnoreCase(p.extension);
    }
}
