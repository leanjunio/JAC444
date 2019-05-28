/**
 * MyPoint
 * 
 * Represents a point with x and y coordinates
 */
import java.lang.Math;

public class MyPoint {
  private int x;
  private int y;

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public MyPoint() {
    this.x = 0;
    this.y = 0;
  }

  public MyPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns that distance between the object's current point and the specified point
   * @return Distance from the current point to the specified point (x, y)
   */
  public double distance(int x, int y) {
    double totalX = this.x - x;
    double totalY = this.y - y;
    double root = (totalX * totalX) + (totalY * totalY);
    return Math.sqrt(root);
  }
}