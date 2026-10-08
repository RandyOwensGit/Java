public class Person {

    private int age;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age += age;
    }

    public String toString() {
        return this.name + " (" + this.age + ")";
    }

}
