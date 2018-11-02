package com.trach.bank.dao;

import com.trach.bank.model.Group;

public interface GroupDao {
    Group findGroupByName(String name);
}
