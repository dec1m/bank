package com.trach.bank.services.interfaces;

import com.trach.bank.model.Group;

public interface GroupService {
    Group findGroupByName(String name);
}
