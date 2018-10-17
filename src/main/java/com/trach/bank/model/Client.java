package com.trach.bank.model;

import javax.persistence.*;
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
        @NamedQuery(name= Client.FIND_ALL, query = "SELECT c FROM Client c"),
        @NamedQuery(name= Client.GET_BY_ID, query = "SELECT c FROM Client c WHERE c.id = :id")
})

public class Client  implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private int phone_number;
    private LocalDate birthDay;
    private List<Account> accountList;

    public static final String GET_BY_ID = "CLIENT.GET_BY_ID";
    public static final String FIND_ALL = "CLIENT.FIND_ALL";
    public static final String DELETE_BY_ID = "CLIENT.DELETE_BY_ID";
    public static final String GET_LAST_NAME_BY_ID = "CLIENT.GET_LAST_NAME_BY_ID";

    public Client() {
    }

    public Client(String firstName, String lastName, String password, int phone_number,
                  LocalDate birthDay, List<Account> accountList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_number = phone_number;
        this.birthDay = birthDay;
        this.accountList = accountList;
    }

    public Client(long id, String firstName, String lastName,
                  String password, int phone_number, LocalDate birthDay, List<Account> accountList) {
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

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                phone_number == client.phone_number &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(password, client.password) &&
                Objects.equals(birthDay, client.birthDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, password, phone_number, birthDay);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName= '" + firstName + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", password= '" + password + '\'' +
                ", phone_number= " + phone_number +
                ", birthDay= " + birthDay +

                '}';
    }
}
