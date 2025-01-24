package binding;

import java.util.Random;

class Character {

    //public String greeting = "Hola, buenos dias";

    public void greet() {
        System.out.println("Hola, buenos dias");
    }
}

class OptimisticCharacter extends Character {

    @Override
    public void greet() {
        System.out.println("Hola, hoy va a ser un dia precioso");
    }
}

class PessimisticCharacter extends Character {

    @Override
    public void greet() {
        System.out.println("Hola, alguien me va a fastidiar el dia");
    }
}

public class LateBindingDemo {

    public static void main(String[] args) {

        // Variable de tipo Character apuntando a null (no guarda ninguna referencia a ningún objeto)
        Character character = null;

        // El operador new crea un objeto de tipo Character y devuelve una referencia
        // la referencia (de tipo Character) se asigna (y, por tanto, se almacena) a la variable character
        character = new Character();

        // Llamada a un método de instancia (late binding)
        // Es un mensaje que responde en este caso un objeto de tipo Character
        // (el objeto referenciado por la referencia almacenada en la variable character)
        character.greet(); // Hola, buenos días

        OptimisticCharacter leoncio = new OptimisticCharacter();
        PessimisticCharacter triston  = new PessimisticCharacter();

        leoncio.greet();
        triston.greet();

        // La variable character es de tipo Character (almacena referencias de tipo Character)
        // La variable leoncio es de tipo OptimisticCharacter
        // La referencia almacenada en la variable leoncio es de tipo OptimisticCharacter
        // Hay que trasformarla en una referencia de tipo Character (conversion de tipo, casting)
        // En este caso el casting es desde un tipo mas especifico a una más general, ascendemos por la jerarquía
        // Por tanto, se trata de un upcasting
        // Un upcasting siempre es factible y, por tanto, no hace falta indicarlo de forma explícita
        // Se realiza la conversion de la referencia de manera implícita
        // Una vez convertida se asigna a la variable character
        character = leoncio; // Upcasting

        // Aunque la referencia es de tipo Character se enlaza la llamada con la versión del método greet de la clase
        // OptimisticCharacter dado que es un método de instancia no final, se realiza un enlace tardío, basándose
        // en el tipo real del objeto apuntado por la referencia almacenada en la variable character y no en el tipo
        // de la referencia
        character.greet(); // Hola, hoy va a ser un día precioso

        // En este caso indicamos la conversion de manera explícita
        // (el IDE lo muestra en gris para indicar que no es necesaria)
        character = (Character) triston; // Upcasting
        character.greet(); // Hola, alguien me va a fastidiar el dia

        // La variable character almacenará una referencia a un objeto de tipo PessimisticCharacter o OptimisticCharacter
        // dependiendo del resultado de nextBoolean
        character = new Random().nextBoolean() ? new PessimisticCharacter() : new OptimisticCharacter();
        // Por tanto, el compilador no puede saber el tipo del objeto apuntado por la referencia almacenada en la variable
        // Como se trata de un método de instancia no final,
        // no hay más remedio que postergar al momento de ejecutar la instrucción character.greet()
        // la selección de la version del método greet que se va a usar
        // dado que la version a elegir depende del tipo del objeto referenciado y no del tipo de la referencia
        // El tipo de la referencia se corresponde con el tipo de la variable que la almacena: Character
        // Pero el tipo del objeto, solo se puede saber en tiempo de ejecución
        character.greet();
    }

}
