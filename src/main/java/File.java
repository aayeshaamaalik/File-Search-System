import java.util.List;

public class File extends Entry {
    private List<Byte> content;

    public File(String name, List<Byte> content) {
        super(name);
        this.content = content;
    }

    public String getExtension() {
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex == -1) ? "" : name.substring(dotIndex + 1);
    }

    public void setContent(List<Byte> content) {
        this.content = content;
    }

    public List<Byte> getContent() {
        return content;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public int getSize() {
        return content != null ? content.size() : 0;
    }
}
