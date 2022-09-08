import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {
    public static void main(String[] args){
        // reference to static method
        List<Employee> employees = Java8Test.getEmployees();
        employees.forEach(System.out::println);

        employees = employees
                .stream()
                .filter(s -> s.role.equals("Developer"))
                .collect(Collectors.toList());
        employees.forEach(System.out::println);

        employees = Employee.sortEmployee(employees);
        employees.forEach(System.out::println);

        Maths a = (x, y) -> x + y;
        System.out.println(a.operacion(2, 3));
    }


    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        //Stream.iterate(initial value, next value)
        Stream.iterate(0, n -> n + 1)// <-- Streams Object
                .limit(10)
                .forEach(
                        x -> {// <-- Lambda -
                            list.add(
                                    new Employee(x.toString(), String.format("Employe%d",x), (x%2==0) ? "Developer" : "Tester")
                            );
                        }
                );
        return list;
    }
}

class Employee {
    public String idEmployee;
    String name;
    public String role;

    Employee(String idEmployee, String name, String role){
        this.idEmployee = idEmployee;
        this.name = name;
        this.role = role;
    }

    public String toString(){
        return String.format("%s - %s, %s", idEmployee, name, role);
    }

    public static List<Employee> sortEmployee(List<Employee> list){
        Collections.sort(list, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.idEmployee.compareTo(e1.idEmployee);
            }
        });
        return list;
    }
}

interface Arithmetic {
    int add(int a, int b);

    // static method in a interface
    static int multiply(int a, int b) {
        return a * b;
    }

    // abstract
    public double operacion(double x, double y);
}

interface Maths {
    public double operacion(double x, double y);
}