import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private List<Entry> entries;

    public Directory(String name) {
        super(name);
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (Entry entry : entries) {
            totalSize += entry.getSize();
        }
        return totalSize;
    }
}
