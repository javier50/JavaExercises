package core;

import java.util.HashMap;
import java.util.Map;

public class HasCodeEx {

    public static void main(String[] args) {
        // Validate student
        /*Student student1 = new Student("Javier", 1);
        Student student2 = new Student("Gio", 2);

        System.out.printf("is it the same? R: %b%n", student1.equals(student2));
*/

        Map<Student, String> map = new HashMap<>();
        Map<Student, String> set = new HashMap<>();

        Student p1 = new Student("Alice", 30);
        Student p2 = new Student("Alice", 30);


        map.put(p1, "Ingeniera");
        map.put(p2, "Ingeniera2");

        set.put(p1, "Ingeniera");
        set.put(p2, "Ingeniera2");


        // Intentamos obtener el valor usando p2
        System.out.println("Resultado: " + map.get(p2));
    }


}

class Student {
    String name;
    int regNo;

    Student(String name, int regNo) {
        this.name = name;
        this.regNo = regNo;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.regNo == other.regNo;
    }*/

    @Override
    public int hashCode() {
        // return Objects.hash(name, regNo); // best practice
        return 1;//Integer.hashCode(regNo); // bad practice
    }
}