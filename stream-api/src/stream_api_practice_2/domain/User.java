package stream_api_practice_2.domain;

import stream_api_practice_2.Main;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Main.Nationality nationality;

    public User() {
    }

    public User(long id, String firstName, String lastName, int age, Main.Nationality nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Main.Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Main.Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
