/**
 * Tester
 */
public class Tester {

  public static void main(String[] args) {
    Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));

    // Display area + perimeter
    System.out.println("Area: " + t1.getArea());
    System.out.println("Perimeter: " + t1.getPerimeter());

    // Check for contains
    System.out.print("t1 contains...: ");
    System.out.print(t1.contains(3, 3));
  }
}