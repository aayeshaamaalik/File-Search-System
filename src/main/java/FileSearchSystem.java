import java.util.ArrayList;
import java.util.List;

public class FileSearchSystem {
    public List<File> search(Directory dir, Specification spec, Param params) {
        List<File> results = new ArrayList<>();
        searchRecursive(dir, spec, params, results);
        return results;
    }

    private void searchRecursive(Directory dir, Specification spec, Param params, List<File> results) {
        for (Entry entry : dir.getEntries()) {
            if (entry.isDirectory()) {
                searchRecursive((Directory) entry, spec, params, results);
            } else {
                File file = (File) entry;
                if (spec.isSatisfied(params, file)) {
                    results.add(file);
                }
            }
        }
    }
}
