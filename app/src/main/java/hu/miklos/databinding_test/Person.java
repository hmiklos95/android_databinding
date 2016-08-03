package hu.miklos.databinding_test;

/**
 * Created by Miklós on 2016. 08. 03..
 */
public class Person {
    private String name;
    private String addredess;
    private String email;
    private int age;

    public Person(String name, String addredess, String email, int age) {
        this.name = name;
        this.addredess = addredess;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddredess() {
        return addredess;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddredess(String addredess) {
        this.addredess = addredess;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
