package exercises.multimedia;

public class Main {

    public static void main(String[] args) {

        MultimediaList listaMulti = new MultimediaList(10);

        fillMultimediaList(listaMulti);

        printMultimediaList(listaMulti);

        testFindMovie(listaMulti);

    }

    private static void printMultimediaList(MultimediaList listaMulti) {
        System.out.println(listaMulti);
    }

    private static void fillMultimediaList(MultimediaList listaMulti) {

        Movie torrente = new Movie("Torrente, el brazo tonto de la ley", "Santiago Segura", 97,
                Multimedia.Format.DVD, "Santiago Segura", "Neus Asensi");

        Movie titanic = new Movie("Titanic", "James Cameron", 195,
                Multimedia.Format.DVD, "Leonardo DiCaprio", "Kate Winslet");

        Movie noah = new Movie("El diario de Noah", "Nick Cassavetes", 124,
                Multimedia.Format.DVD, "Ryan Gosling", "Rachel McAdams");


        listaMulti.add(titanic);
        listaMulti.add(noah);
        listaMulti.add(torrente);
    }

    private static void testFindMovie(MultimediaList listaMulti) {

        Movie movie = new Movie("Titanic", "James Cameron",
                0,null,"null","null");

        int position = listaMulti.indexOf(movie);

        if (position == -1) {
            System.out.println("No se encontró la película " + movie.getTitulo());
        } else {
            System.out.println(listaMulti.get(position));
        }
    }
}
