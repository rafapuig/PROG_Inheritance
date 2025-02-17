package exercises.multimedia;

import java.util.Objects;
import java.util.StringJoiner;

public class Multimedia {

    public enum Format {WAV, MP3, MIDI, AVI, MOV, MP4, CD_AUDIO, DVD}

    protected final String titulo;
    protected final String author;
    protected final Format format;
    protected final int duration;

    public Multimedia(String titulo, String author, Format format, int duration) {
        this.format = format;
        this.titulo = titulo;
        this.duration = duration;
        this.author = author;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAuthor() {
        return author;
    }

    public int getDuration() {
        return duration;
    }

    public Format getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + " {", "}")
                .add("titulo = '" + titulo + "'")
                .add("author = '" + author + "'")
                .add("format = " + format)
                .add("duration = " + duration)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Multimedia that)) return false;
        return Objects.equals(titulo, that.titulo) && Objects.equals(author, that.author);
    }


    @Override
    public int hashCode() {
        int hash = 37;
        hash = 59 * hash + titulo.hashCode();
        hash = 59 * hash + author.hashCode();
        return hash;
    }

    public static void main(String[] args) {
        Multimedia multimedia = new Multimedia("Titanic", "Perico", Format.MP3, 300);
        System.out.println(multimedia);
    }
}
