package supermarket;

public class Phone {
    private double screenSize;
    private String name;
    private String os;
    public String brand;
    static int count = 1;

    public Phone(String name, String os, String brand, double screenSize) {
        this.name = name;
        this.os = os;
        this.brand = brand;
        this.screenSize = screenSize;
    }

    public String describe() {
        return this.name + "-" + this.brand + "-" + this.os + "-" + this.screenSize;
    }

    public static int getCount() {
        return count;
    }
}