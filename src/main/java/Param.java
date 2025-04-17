public class Param {
    public String extension;
    public int minSize;
    public int maxSize;
    public String name;

    public Param(String extension, int minSize, int maxSize, String name) {
        this.extension = extension;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.name = name;
    }
}
