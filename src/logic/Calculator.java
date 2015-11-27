package logic;

/**
 * Created by Yevhen on 27.11.2015.
 */
public class Calculator {
    private int a;
    private int b;

    public Calculator() {
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getSum() {
        return a + b;
    }

    public int getSubtract() {
        return a - b;
    }
}
