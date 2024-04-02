package sem_2.hw_2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class Program {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Animal[] animals = new Animal[]{
                new Dog("Тузик", 3, "Дворняга"),
                new Dog("Герда", 2, "Тойтерьер"),
                new Cat("Барсик", 1, "Белый"),
                new Cat("Мурзик", 1, "Чёрный"),
                new Cat("Гав", 5, "Чёрный")
        };
        for (Animal animal : animals) {
            Class<?> childClass = animal.getClass();
            Class<?> parentClass = childClass.getSuperclass();
            System.out.println("\nКласс " + childClass.getSimpleName() + " имеет поля:\n");
            Field[] parentFields = parentClass.getDeclaredFields();
            for (Field field : parentFields) {
                System.out.println("Поле родительского класса: " + field.getName() + " - " + field.get(animal));
            }
            Field[] fields = childClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.set(animal, 10);
                } else if (field.getType() == boolean.class) {
                    field.setAccessible(true);
                    System.out.println("Поле наследного класса:    " + field.getName() + " - " + field.get(animal));
                }
            }

            // Вызовем метод "makeSound" при его наличии
            Method[] methods = childClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("makeSound")) {
                    method.invoke(animal);
                    break;
                }
            }
        }
    }
}