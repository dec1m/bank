package com.trach.bank.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "clients")
@SuppressWarnings("ALL")
@NamedQueries({
        @NamedQuery(name = Client.GET_LAST_NAME_BY_ID, query = "SELECT c.firstName FROM Client c WHERE id = :id"),
        @NamedQuery(name = Client.DELETE_BY_ID, query = "DELETE FROM Client c WHERE c.id = :id"),
        @NamedQuery(name = Client.FIND_ALL_ACCOUNT, query = "SELECT c.account FROM Client c WHERE id = :id"),
        @NamedQuery(name = Client.FIND_ALL, query = "SELECT c FROM Client c"),
        @NamedQuery(name = Client.GET_BY_ID, query = "SELECT c FROM Client c WHERE c.id = :id"),
        @NamedQuery(name = Client.GET_BY_LOGIN, query = "SELECT c FROM Client c WHERE c.login = :login"),

})

public class Client implements Serializable {


    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private int phone_number;
    private LocalDate birthDay;
    private String login;
    private Account account;
    private Group group;

    public static final String FIND_BY_ACCOUNT_ID = "CLIENT.FIND_BY_ACCOUNT_ID";
    public static final String GET_BY_LOGIN = "CLIENT.GET_BY_LOGIN";
    public static final String GET_BY_ID = "CLIENT.GET_BY_ID";
    public static final String FIND_ALL_ACCOUNT = "CLIENT.FIND_ALL_ACCOUNT";
    public static final String FIND_ALL = "CLIENT.FIND_ALL";
    public static final String DELETE_BY_ID = "CLIENT.DELETE_BY_ID";
    public static final String GET_LAST_NAME_BY_ID = "CLIENT.GET_LAST_NAME_BY_ID";

    public Client() {
        account = new Account();
        account.setMoney(100);
        account.setClient(this);
    }

    public Client(String firstName, String lastName, String password, int phone_number, String login,
                  LocalDate birthDay, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_number = phone_number;
        this.birthDay = birthDay;
        this.account = account;
    }

    public Client(long id, String firstName, String lastName,
                  String password, int phone_number, LocalDate birthDay, String login, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_number = phone_number;
        this.birthDay = birthDay;
        this.account = account;
    }

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 15, message = "{firstName.size.error}")
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    @NotNull
    @Size(min = 2, max = 15, message = "{lastName.size.error}")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "password")
    @Size(min = 6, max = 60, message = "{password.size.error}")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Min(value = 10000, message = "{phone_number.size.error}")
    @Max(value = 999999999, message = "{phone_number.size.error}")
    @Column(name = "phone_number")
    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @Column(name = "birth_day")
    @NotNull
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }


    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "account_id")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
      public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @NotNull
    @Size(min = 4, max = 15, message = "{error_login}")
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
                Objects.equals(getLogin(), client.getLogin()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPassword(), getPhone_number(), getBirthDay(), getLogin());
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
                '}';
    }
}
