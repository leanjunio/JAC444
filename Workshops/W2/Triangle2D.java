/**
 * Triangle2D
 */
import java.awt.geom.Line2D;

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

  /**
   * This function returns a boolean relative to whether a point is inside a triangle or not
   * @param p The point to check
   * @return True or False
   */
  public boolean contains(MyPoint p) {
    MyPoint pA = this.p1;
    MyPoint pB = this.p2;
    MyPoint pC = this.p3;

    // Original triangle's line segmenets
    Line2D.Double lineAB = new Line2D.Double(pA.getX(), pA.getY(), pB.getX(), pB.getY());
    Line2D.Double lineBC = new Line2D.Double(pB.getX(), pB.getY(), pC.getX(), pC.getY());
    Line2D.Double lineCA = new Line2D.Double(pC.getX(), pC.getY(), pA.getX(), pA.getY());

    // Line segments from 'p' to A, B, or C
    Line2D.Double LinePA = new Line2D.Double(p.getX(), p.getY(), pA.getX(), pA.getY());
    Line2D.Double LinePB = new Line2D.Double(p.getX(), p.getY(), pB.getX(), pB.getY());
    Line2D.Double LinePC = new Line2D.Double(p.getX(), p.getY(), pC.getX(), pC.getY());
    
    boolean PAIntersects = LinePA.intersectsLine(lineAB) || LinePA.intersectsLine(lineBC) || LinePA.intersectsLine(lineCA);
    boolean PBIntersects = LinePB.intersectsLine(lineAB) || LinePB.intersectsLine(lineBC) || LinePB.intersectsLine(lineCA);
    boolean PCIntersects = LinePC.intersectsLine(lineAB) || LinePC.intersectsLine(lineBC) || LinePC.intersectsLine(lineCA);

    // TODO: Check to see if there are at least two intersections, if there are at least two, that means that the point is outside
    return !(PAIntersects || PBIntersects || PCIntersects);
  }

  public boolean contains(Triangle2D t) {
    boolean containsP1 = this.contains(t.getP1());
    boolean containsP2 = this.contains(t.getP2());
    boolean containsP3 = this.contains(t.getP3());

    boolean pointsContainedCurrentObject = containsP1 && containsP2 && containsP3;
    return pointsContainedCurrentObject;
  }

  public boolean overlaps(Triangle2D t) {

  }
}