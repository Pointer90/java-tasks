import point.Point;

public class DemoPoint {
    public static void main(String[] args) throws Exception {
        Point p = new Point(23, 0, new double[]{1., 0.}, new double[]{1., 2., 4.});
        Point p1 = new Point(42, 5, new double[]{0., 1.}, new double[]{3., 2., 2.});
        System.out.println(p.toString());
        System.out.println(p.calcDistance(5));
        System.out.println(p.calcSpeed(5));
        System.out.println(p.calcAcceleration());
        System.out.println(p.calcDistanceBetweenPoints(p1, 5));
    }
}
