package com.trach.bank.services;

import com.trach.bank.dao.GroupDao;
import com.trach.bank.model.Group;
import com.trach.bank.services.interfaces.GroupService;

public class GroupServiceImpl implements GroupService {
    GroupDao groupDao;
    @Override
    public Group findGroupByName(String name) {
       return  groupDao.findGroupByName(name);
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}
