package lec_2;

public class Car {
    public String name;
    public String price;
    public String engType;
    public String engPower;
    public int maxSpeed;


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String name) {
        this.name = name;
        this.price = "1000000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 190;
    }
}
