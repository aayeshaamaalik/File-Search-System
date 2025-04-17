public abstract class Entry {
    protected String name;

    public Entry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean isDirectory();

    public abstract int getSize();
}
