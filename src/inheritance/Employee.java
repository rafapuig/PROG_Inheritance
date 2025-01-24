package inheritance;

public class Employee {

    private String name = "Anonimo";

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Armando Bronca");
        System.out.println("Nombre:" + employee.getName());
    }
}