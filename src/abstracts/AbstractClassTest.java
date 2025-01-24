package abstracts;

abstract class Shape {

    private String name;

    public Shape() {
        name = "Forma desconocida";
    }

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract void draw();
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        super("Rectángulo");
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Dibujando un rectángulo...");
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * (width + height);
    }
}

class Circle extends Shape {
    private final double radius;
    public Circle(double radius) {
        super("Círculo");
        this.radius = radius;
    }


    @Override
    public void draw() {
        System.out.println("Dibujando un circulo...");
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }
}

class ShapeUtil {
    public static void drawShapes(Shape[] list) {
        for (Shape shape : list) {
            // Dibuja la forma, no importa el tipo que sea
            shape.draw(); // Late binding
        }
    }

    public static void printShapeDetails(Shape[] list) {
       for (Shape shape : list) {
           String name = shape.getName();           //Late binding
           double area = shape.getArea();           //Late binding
           double perimeter = shape.getPerimeter(); //Late binding
           // Imprimir detalles
           System.out.println("Nombre: " + name);
           System.out.println("Area: " + area);
           System.out.println("Perímetro: " + perimeter);
       }
    }
}

public class AbstractClassTest {

    {
        Shape shape = new Rectangle(2.0,5.0); // Upcasting en acción
        double area = shape.getArea(); // Late binding en acción
    }

    public static void main(String[] args) {
        // Crear algunas formas e imprimir detalles
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(4.0);    // Upcasting
        shapes[1] = new Rectangle(2.0,3.0); //Upcasting

        // Dibujar todas las formas
        ShapeUtil.drawShapes(shapes);
        // Imprimir detalles de todas las formas
        ShapeUtil.printShapeDetails(shapes);
    }

}
