package model;

public class Programmer extends Employee {

    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Programmer [name='" + getName() +"', age=" + getAge() + ", salary=" + getSalary() + ", language='" + language + "']";
    }
}
