public class ArgumentTest {
  public static void main(String[] args) {
    for (String str : args) {
      System.out.println(str);
    }
  }
}

public class Addition {
  public static void main(String[] args) {
    if (args.length == 2) {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      System.out.println("The addition of two numbers: " + (a + b));
    } else
      System.out.println("Please enter two integer values!!!");
  }
}