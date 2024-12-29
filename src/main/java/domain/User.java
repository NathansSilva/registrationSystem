package domain;

public class User {

    private String name;
    private int age;
    private String email;
    private double height;

    public User(String name, int age, String email, double height) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.height = height;
    }


    @Override
    public String toString() {
        return "Name: " + name +
                ", Age: " + age +
                ", E-mail: " + email +
                ", Height: " + height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
