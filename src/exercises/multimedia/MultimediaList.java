package exercises.multimedia;

public class MultimediaList {

    private int count;
    Multimedia[] list;

    public MultimediaList(int capacity) {
        list = new Multimedia[capacity]; // Composición, la parte es el array de referencias a objetos Multimedia
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean add(Multimedia m) {
        if (count == list.length) return false;
        list[count++] = m;
        return true;
    }

    public Multimedia get(int index) {
        return list[index];
    }

    public int indexOf(Multimedia m) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(m)) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            Multimedia m = list[i];
            builder.append(m.getClass().getSimpleName())
                    .append("[" + i + "]: ")
                    .append(m)
                    .append("\n");
        }
        return builder.toString();
    }
}
