package org.amqp.spring.jms.bo;

import java.io.Serializable;

public class Notification implements Serializable {

    private String firstName;
    private String lastName;
    private String interests;
    private int age;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", interests='" + interests + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}
