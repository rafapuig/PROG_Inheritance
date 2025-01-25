package model;

public class Employee extends Person {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name='" + getName() +"', age=" + getAge() + "salary=" + salary + "]";

    }
}
