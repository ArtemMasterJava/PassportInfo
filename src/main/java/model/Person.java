package model;

import java.io.Serializable;

/**
 * Created by USER on 27.06.2015.
 */
public class Person implements Serializable {
    final private String name;
    final private String lastName;
    final private int age;
    final private String address;
    final private int id;

    private Person(Builder builder){
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.id = builder.id;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("model.Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address='").append(address).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        return !(address != null ? !address.equals(person.address) : person.address != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public static class Builder {
        private String name;
        private String lastName;
        private int age;
        private int id;
        private String address;

        public Builder(Person original){
            this.name = original.name;
            this.lastName = original.lastName;
            this.age = original.age;
            this.id = original.id;
            this.address = original.address;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }
        public Builder age (int value){
            this.age = value;
            return this;
        }
        public Builder id (int value){
            this.id = value;
            return this;
        }
        public Builder address (String value){
            this.address = value;
            return this;
        }
    }
}
