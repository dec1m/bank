package com.trach.bank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@SuppressWarnings("ALL")
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = Account.DELETE_BY_ID, query = "DELETE FROM Account a WHERE a.id = :id"),
        @NamedQuery(name = Account.GET_BY_ID, query = "SELECT a FROM Account a WHERE a.id = :id"),

})
public class Account  implements Serializable {
    private long id;
    private int money;
    private  Client client;
    private Currency currency;


    public static final String DELETE_BY_ID = "ACCOUNT.DELETE_BY_ID";
    public static final String GET_BY_ID = "ACCOUNT.GET_BY_ID";

    public Account() {
    }

    public Account(int money, Client client,Currency currency) {
        this.currency = currency;
        this.money = money;
        this.client = client;
    }

    public Account(long id, int money, Client client,Currency currency) {
        this.currency = currency;
        this.id = id;
        this.money = money;
        this.client = client;
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
    @Column(name = "money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                money == account.money &&
                Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, money, client);
    }

    @Override
    public String toString() {
        return "Account{" +
                "Owner=" + client.getLogin()+
                "id=" + id +
                ", money=" + money +
                '}';
    }

}