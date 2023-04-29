package com.builderAPI.builder.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity class that represents a user
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String emailAddress;
    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) // many-to-many User - Role | role should be eagerly fetched when user is retrieved
    @JoinTable(name = "user_roles", // mapping details of relationship + name of join table
            joinColumns = @JoinColumn(name = "user_id"), // specifies FK column that references User's PK
            inverseJoinColumns = @JoinColumn(name = "role_id")) //specifies FK column in join table that references Role's PK
    private Set<Role> roles = new HashSet<>();



    /**
     * Default constructor for User class
     */
    public User() {
    }

    /**
     * Constructor with Parameters for User class
     * @param id the user's ID #
     * @param userName the user's name
     * @param emailAddress the user's email
     * @param password the user's password
     * @param roles the user's roles
     */
    public User(Long id, String userName, String emailAddress, String password, String roles) {
        this.id = id;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Getter Method for user ID
     * @return ID for the user
     */
    public Long getId() {
        return id;
    }

    /**
     * setter method for user ID
     * @param id the ID to set for user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter method for Name of User
     * @return the name of user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for use rname
     * @param userName the name set for the user
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * getter method for email address
     * @return the email address of the user
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * setter method for user email address
     * @param emailAddress the email address to set for the user
     */

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * getter method for use rpassword
     * @return the password for the user
     */

    public String getPassword() {
        return password;
    }

    /**
     * setter method for password
     * @param password the password set for the user
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter method for user roled
     * @return roles the roles to set for user
     */
    public String getRoles() {
        return roles;
    }

    /**
     * setter method for user roles
     * @param roles the roles to set for the user
     */

    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * Override of toString method to return user information as a string
     *
     * @return a string representation of the user info
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
