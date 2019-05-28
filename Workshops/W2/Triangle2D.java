/**
 * Triangle2D
 */
public class Triangle2D {
  MyPoint p1;
  MyPoint p2;
  MyPoint p3;

  /**
   * A no-arg constructor that creates a default triangle with the points (0, 0), (1, 1), and (2, 5)
   */
  public Triangle2D() {
    this.p1 = new MyPoint(0, 0);
    this.p1 = new MyPoint(1, 1);
    this.p1 = new MyPoint(2, 5);
  }

  /**
   * A constructor that creates a triangle with the specified points
   */
  public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
    this.p1 = p1;
    this.p1 = p2;
    this.p1 = p3;
  }

  public MyPoint getP1() {
    return this.p1;
  }

  public void setP1(MyPoint p1) {
    this.p1 = p1;
  }

  public MyPoint getP2() {
    return this.p2;
  }

  public void setP2(MyPoint p2) {
    this.p2 = p2;
  }

  public MyPoint getP3() {
    return this.p3;
  }

  public void setP3(MyPoint p3) {
    this.p3 = p3;
  }

  /**
   * Calculates the area of the current object's triangle by:
   * 1. Get all the lengths of all the sides of the triangle
   * 2. Calculate the semi-perimeter of the triangle using the sides that were calculated
   * 3. Calculate the area of the triangle
   * @return area of current object's triangle
   */
  public double getArea() {
    double distanceP1P2 = p1.distance(p2.getX(), p2.getY());
    double distanceP2P3 = p2.distance(p3.getX(), p3.getY());
    double distanceP3P1 = p3.distance(p1.getX(), p1.getY());

    double s = (distanceP1P2 + distanceP2P3 + distanceP3P1)/2;
    double area = Math.sqrt(s* (s - distanceP1P2) * (s - distanceP2P3) * (s - distanceP3P1));
    return area;
  }

  /**
   * Calculates and returns the perimeter of the current' object's triangle
   * @return object's perimeter
   */
  public double getPerimeter() {
    double distanceP1P2 = p1.distance(p2.getX(), p2.getY());
    double distanceP2P3 = p2.distance(p3.getX(), p3.getY());
    double distanceP3P1 = p3.distance(p1.getX(), p1.getY());
    return distanceP1P2 + distanceP2P3 + distanceP3P1;
  }

  public boolean contains(MyPoint p) {

  }

  public boolean contains(Triangle2D t) {

  }

  public boolean overlaps(Triangle2D t) {

  }
}