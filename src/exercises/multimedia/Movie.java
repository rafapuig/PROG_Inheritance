package exercises.multimedia;

import java.util.StringJoiner;

public class Movie extends Multimedia {

    protected final String mainActor;
    protected final String mainActress;

    public Movie(String titulo, String author, int duration, Format format, String mainActor, String mainActress) {
        super(titulo, author, format, duration);
        if (mainActor == null || mainActor.isEmpty() && mainActress == null || mainActress.isEmpty())
            throw new IllegalArgumentException("Se debe especificar o bien un actor o bien una actriz");
        this.mainActor = mainActor;
        this.mainActress = mainActress;
    }

    public String getMainActor() {
        return mainActor;
    }
    public String getMainActress() {
        return mainActress;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "{", "}")
                .add("titulo='" + titulo + "'")
                .add("author='" + author + "'")
                .add("format=" + format)
                .add("duration=" + duration)
                .add("mainActor='" + mainActor + "'")
                .add("mainActress='" + mainActress + "'")
                .toString();
    }

    public static void main(String[] args) {
        Movie pelicula = new Movie("Titanic","James Cameron",180, Format.DVD,
                "Leonardo DiCaprio", "Kate Winslet");

        System.out.println(pelicula);
    }
}
