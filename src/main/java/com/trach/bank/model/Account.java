package com.trach.bank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account  implements Serializable {
    private long id;
    private int money;
    private  Client client;

    public Account() {
    }

    public Account(int money, Client client) {
        this.money = money;
        this.client = client;
    }

    public Account(long id, int money, Client client) {
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
    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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