package lec_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("Павел", 23), new User("Аркадий", 23), new User("Рома", 44));

        list.stream().map(user -> new User(user.name, user.age -5)).filter(user -> user.age <= 25).forEach(System.out::println);

    }
}