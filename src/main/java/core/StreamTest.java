package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    String name;
    String lastName;
    String role;

    public String toString(){
        return String.format("%s %s(%s)", lastName, name, role);
    }
}
public class StreamTest {
    public static void main(String[] args) {
        int[] array = {2,4,6,3,7,8};
        System.out.println(sumStream(array));
        System.out.println(avgStream(array));
        System.out.println("\n");
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(sumStream(list));
        System.out.println(avgStream(list));

        System.out.println("\n");
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        filterByWord(myList, "c").forEach(System.out::println);

        List<Employee> employeeList = getEmployeeList();
        filterByRole(employeeList, "Developer").forEach(System.out::println);
        System.out.println("\n");
        filterByName(employeeList, "0").forEach(System.out::println);
    }

    public static int sumStream(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    public static double avgStream(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
    }

    public static int sumStream(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static double avgStream(int[] array) {
        return Arrays.stream(array).average().getAsDouble();
    }

    public static List<String> filterByWord(List<String> list, String word){
        return list
                .stream()
                .filter(s -> s.startsWith(word))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        IntStream.range(0,3).forEach(i->{
            Employee temp = new Employee();
            temp.name = "Jonh" +  i;
            temp.lastName = "Smith" + i;
            temp.role = "Developer";
            employeeList.add(temp);
        });
        IntStream.range(0,3).forEach(i->{
            Employee temp = new Employee();
            temp.name = "Diya" +  i;
            temp.lastName = "Das" + i;
            temp.role = "Devops";
            employeeList.add(temp);
        });
        IntStream.range(0,3).forEach(i->{
            Employee temp = new Employee();
            temp.name = "Sri" +  i;
            temp.lastName = "Devi" + i;
            temp.role = "Scrum Master";
            employeeList.add(temp);
        });
        return employeeList;
    }
    public static List<Employee> filterByRole(List<Employee> list, String role){
        return list
                .stream()
                .filter(s -> s.role.equals(role))
                .collect(Collectors.toList());
    }
    public static List<Employee> filterByName(List<Employee> list, String str){
        return list
                .stream()
                .filter(s -> s.name.contains(str))
                .collect(Collectors.toList());
    }
}
