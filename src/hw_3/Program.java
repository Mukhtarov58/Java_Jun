package hw_3;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        Student student = new Student("Иванов Иван", 20, 3.5);
        serializeStudent(student, "student.ser");
        Student deserializedStudent = deserializeStudent("student.ser");
        System.out.println("Десериализованный объект:");
        System.out.println(deserializedStudent);
    }

    private static void serializeStudent(Student student, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(student);
            System.out.println("Объект сериализован в " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student deserializeStudent(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Student) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}