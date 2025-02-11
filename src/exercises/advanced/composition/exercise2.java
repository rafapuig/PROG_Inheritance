package exercises.advanced.composition;

class Point {
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
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public void translate(int dx, int dy) {
        for (int i = 0; i < points.length; i++) {

            Point punto = points[i];
            double x = punto.getX() + dx;
            punto.setX(x);
            double y = punto.getY() + dy;
            punto.setY(y);
        }
    }

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
                    .append(i+1)
                    .append(": ")
                    .append(points[i])
                    .append("\n");

        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

public class exercise2 {

    public static void main(String[] args) {
        Polygon polygon = new Polygon(new Point[] {
                new Point(2, 3),
                new Point(4, 5),
                new Point(6, 7)}
        );

        System.out.println(polygon);
        polygon.scale(2, 3);
        System.out.println(polygon);

        polygon.translate(-4, -6);
        System.out.println(polygon);

        System.out.println(polygon.getVerticesCount());
    }

}
