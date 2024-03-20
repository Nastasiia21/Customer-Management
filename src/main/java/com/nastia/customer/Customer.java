package com.nastia.customer;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Customer entity representing a customer record in the database.
 */
@Entity // Marks this class as a JPA entity.
public class Customer {

    @Id // Indicates the primary key of the entity.
    @SequenceGenerator(
            name = "customer_id_sequence", // Defines a sequence generator named "customer_id_sequence".
            sequenceName = "customer_id_sequence" // Specifies the database sequence name to use.
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // Indicates that the ID should be generated using a database sequence.
            generator = "customer_id_sequence" // Links this ID generation to the defined sequence generator above.
    )
    private Integer id; // Unique identifier for each customer.

    @Column(nullable = false) // Specifies that the name column cannot be null in the database.
    private String name; // Stores the customer's name.

    @Column(nullable = false) // Specifies that the email column cannot be null.
    private String email; // Stores the customer's email address.

    @Column(nullable = false) // Specifies that the age column cannot be null.
    private Integer age; // Stores the customer's age.

    /**
     * Default constructor required by JPA.
     */
    public Customer() {
    }

    /**
     * Constructor with parameters for creating a customer instance with all fields initialized.
     * @param id The unique identifier for the customer.
     * @param name The name of the customer.
     * @param email The email address of the customer.
     * @param age The age of the customer.
     */
    public Customer(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    /**
     * Constructor without the ID for creating a customer where the ID is not initially known.
     * @param name The name of the customer.
     * @param email The email address of the customer.
     * @param age The age of the customer.
     */
    public Customer(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters for each of the properties.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // Method to compare this customer to another object.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(age, customer.age);
    }

    @Override
    public int hashCode() {
        // Generates a hash code for this customer.
        return Objects.hash(id, name, email, age);
    }

    @Override
    public String toString() {
        // Creates a string representation of this customer.
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
