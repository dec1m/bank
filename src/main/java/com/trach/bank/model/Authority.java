package com.trach.bank.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Authority {

    private Long id;
    private String name;
    private List<Group> groups;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
    @ManyToMany(mappedBy = "authorities")

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}