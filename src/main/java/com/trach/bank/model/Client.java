package com.trach.bank.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
@SuppressWarnings("ALL")
@NamedQueries({
        @NamedQuery(name= Client.GET_LAST_NAME_BY_ID, query = "SELECT c.firstName FROM Client c WHERE id = :id"),
        @NamedQuery(name= Client.DELETE_BY_ID, query = "DELETE FROM Client c WHERE c.id = :id"),
        @NamedQuery(name= Client.FIND_ALL_ACCOUNT, query = "SELECT c.accountList FROM Client c WHERE id = :id"),
        @NamedQuery(name= Client.FIND_ALL, query = "SELECT c FROM Client c"),
        @NamedQuery(name= Client.GET_BY_ID, query = "SELECT c FROM Client c WHERE c.id = :id"),
        @NamedQuery(name= Client.GET_BY_LOGIN, query = "SELECT c FROM Client c WHERE c.login = :login"),

})

public class Client  implements Serializable {

    @NotNull
    private long id;
    @NotNull
    @Size(min = 2, max = 15, message = "{firstName.size.error}")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 15, message = "{lastName.size.error}")
    private String lastName;
    @Size(min = 6, max = 32, message = "{password.size.error}")
    private String password;
    @Min(value = 10000, message = "{phone_number.size.error}")
    @Max(value = 999999999, message = "{phone_number.size.error}")
    private int phone_number;
    @NotNull
    private LocalDate birthDay;
    @NotNull
    @Size(min = 4, max = 15, message = "{error_login}")
    private String login;
    @NotNull
    @Size(min = 5, max = 20)
    private String role = "ROLE_USER"; //TODO, default value
    private List<Account> accountList;



    public static final String FIND_BY_ACCOUNT_ID = "CLIENT.FIND_BY_ACCOUNT_ID";
    public static final String GET_BY_LOGIN = "CLIENT.GET_BY_LOGIN";
    public static final String GET_BY_ID = "CLIENT.GET_BY_ID";
    public static final String FIND_ALL_ACCOUNT = "CLIENT.FIND_ALL_ACCOUNT";
    public static final String FIND_ALL = "CLIENT.FIND_ALL";
    public static final String DELETE_BY_ID = "CLIENT.DELETE_BY_ID";
    public static final String GET_LAST_NAME_BY_ID = "CLIENT.GET_LAST_NAME_BY_ID";

    public Client() {
    }

    public Client(String firstName, String lastName, String password, int phone_number, String login,
                  LocalDate birthDay, List<Account> accountList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_number = phone_number;
        this.birthDay = birthDay;
        this.accountList = accountList;
    }

    public Client(long id, String firstName, String lastName,
                  String password, int phone_number, LocalDate birthDay, String login, List<Account> accountList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_number = phone_number;
        this.birthDay = birthDay;
        this.accountList = accountList;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "phone_number")
    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @Column(name = "birth_day")
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getId() == client.getId() &&
                getPhone_number() == client.getPhone_number() &&
                Objects.equals(getFirstName(), client.getFirstName()) &&
                Objects.equals(getLastName(), client.getLastName()) &&
                Objects.equals(getPassword(), client.getPassword()) &&
                Objects.equals(getBirthDay(), client.getBirthDay()) &&
                Objects.equals(getLogin(), client.getLogin()) &&
                Objects.equals(getRole(), client.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPassword(), getPhone_number(), getBirthDay(), getLogin(), getRole());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", phone_number=" + phone_number +
                ", birthDay=" + birthDay +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
