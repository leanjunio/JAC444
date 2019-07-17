package sample;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    int a;
    int b;
    List<Number> correctAnswers = new ArrayList<Number>();
    List<Number> userAnswers = new ArrayList<Number>();

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    public void setUserAnswers(List<Number> userAnswers) {
        this.userAnswers = userAnswers;
    }

    int noCorrectAnswers;

    public Quiz(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.noCorrectAnswers = c;
    }

    public Quiz() {
        this.a = 0;
        this.b = 0;
        this.noCorrectAnswers = 0;
    }

    public void generateCorrectAnswers() {
        correctAnswers.add(this.a + this.b);
        correctAnswers.add(this.a - this.b);
        correctAnswers.add(this.a * this.b);
        correctAnswers.add((double)this.a/this.b);

        System.out.println("Correct Answers: ");
        for (Number n: correctAnswers) {
            System.out.println(n);
        }
    }

    public void checkForCorrectAnswers() {
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                this.noCorrectAnswers++;
            }
        }
    }
}
