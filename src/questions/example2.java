package questions;

abstract class Animal {
    //public int patas = 4;
    private int patas = 4;

    public abstract void eat();

    protected void setPatas(int patas) {
        this.patas = patas;
    }

    public int getPatas() {
        return patas;
    }
}

class Persona extends Animal {

    public Persona() {
        super.setPatas(2);
    }

    //public int patas = 2;
    @Override
    public void eat() {
        System.out.println("Persona eats");
    }

}

class Programmer extends Persona {

    //public int patas = 3;

    public Programmer() {
        super.setPatas(3);
    }

    @Override
    public void eat() {
        System.out.println("Programmer eats");
    }
}


public class example2 {
    public static void main(String[] args) {

        Animal[] animals = new Animal[2];
        animals[0] = new Persona();
        animals[1] = new Programmer();

        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            animal.eat();
            //System.out.println(animal.patas);
            System.out.println(animal.getPatas());
            /*if(animal instanceof Persona persona) {
                System.out.println(persona.patas);
            }
            if (animal instanceof Programmer programmer) {
                System.out.println(programmer.patas);
            }*/

        }

    }
}
