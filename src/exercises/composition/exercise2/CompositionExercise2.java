package exercises.composition.exercise2;

class Point {
    // Nivel de acceso default (clases del mismo paquete que Point)
    double x, y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}


class Polygon {

    private final Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
        // Dependiendo de los requisitos quizá sería mejor hacer una copia de los puntos
        //this.points = Arrays.copyOf(points, points.length);
    }

    public void translate(double dx, double dy) {
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            double x = point.getX() + dx;
            double y = point.getY() + dy;
            point.setX(x);
            point.setY(y);
        }
    }

    public void translate_v2(double dx, double dy) {
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            point.x += dx;
            point.y += dy;
        }
    }

    // Si ubicamos Point y Polygon dentro del mismo paquete
    // podríamos aprovechar el nivel de acceso de paquete (default)
    // y acceder directamente a los campos de clase punto, desde la clase polígono

    public void scale(double factorX, double factorY) {
        for (int i = 0; i < points.length; i++) {
            Point punto = points[i];
            double x = punto.getX() * factorX;
            double y = punto.getY() * factorY;
            punto.setX(x);
            punto.setY(y);
        }
    }

    public int getVerticesCount() {
        return points.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.length; i++) {
            sb.append("Vertex ")
                    .append(i + 1)
                    .append(": ")
                    .append(points[i])
                    .append("\n");

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public double perimeter() {

        double sum = 0;

        for (int i = 0; i < points.length; i++) {
            Point origin = points[i];
            Point dest = points[(i + 1) % points.length];
            double distance = origin.distance(dest);
            sum += distance;
        }
        return sum;
    }
}

public class CompositionExercise2 {

    public static void main(String[] args) {
        Polygon polygon = new Polygon(new Point[]{
                new Point(0, 0),
                new Point(2, 0),
                new Point(2, 2),
                new Point(0, 2)}
        );

        printPolygonInfo(polygon);

        polygon.translate(4, -3);
        printPolygonInfo(polygon);

        polygon.scale(2, 3);
        printPolygonInfo(polygon);
    }

    static void printPolygonInfo(Polygon polygon) {
        System.out.println(polygon);
        System.out.println("Perimetro: " + polygon.perimeter());
        System.out.println("Vertices#: " + polygon.getVerticesCount());
    }

}
