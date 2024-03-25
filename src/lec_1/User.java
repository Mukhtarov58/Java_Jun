package lec_1;

public class User {
    String name;
     int age;

    @Override
    public String toString() {
        return "lec_1.User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
