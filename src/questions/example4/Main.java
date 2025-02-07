package questions.example4;

class Publicacion {

    String getEditorial() { return null; }

    String getAutor() { return null; }

}

class Revista extends Publicacion {
    int getNumero() { return 0; }
}

class Tesis extends Publicacion {
    String getDepartamento() { return null; }
}

public class Main {
    public static void main(String[] args) {
        Publicacion publicacion = null;

        publicacion = new Revista();
        publicacion.getEditorial();
        publicacion.getAutor();

        publicacion = new Tesis();
        publicacion.getEditorial();
        publicacion.getAutor();

        //String a = "";
        //String b = "";

        Integer a = Integer.valueOf(3);
        Integer b = Integer.valueOf(5);

        System.out.println(a + b);


    }
}
