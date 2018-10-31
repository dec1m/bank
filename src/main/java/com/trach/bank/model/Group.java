package com.trach.bank.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Groups")
public class Group {

    private Long id;
    private String name;
    private List<Client> clients;
    private List<Authority> authorities;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "groups")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    @ManyToMany
    @JoinTable(
            name = "group_authorities",
            joinColumns = @JoinColumn(
                    name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "authorities_id", referencedColumnName = "id"))
    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}