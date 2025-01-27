package hiding;

class Animal {
    String name;

    public String sonido() {
        return "Sonido de animal";
    }
}

class Cat extends Animal {
    String name;

    @Override
    public String sonido() {
        return "Miau";
    }
}

public class FieldHidingDemo {

    static void print(Animal animal) {
        // Usa la versión del campo basándose en el tipo de la referencia (variable): Animal
        System.out.println(animal.name); // Early binding cuando se accede a un campo

        if(animal instanceof Cat cat) {
            // Ahora accedemos al campo name con una referencia de tipo Cat
            System.out.println(cat.name); // Early binding cuando se accede a un campo
        }

        // Usa la versión del campo basándose en el tipo del objeto
        System.out.println(animal.sonido()); // Late binding cuando se llama a método de instancia
    }

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.name = "Garfield";

        Animal animal = cat;
        animal.name = "Don gato";

        print(cat);

        Animal a = new Animal();
        a.name = "Animalillo";
        print(a);
    }
}