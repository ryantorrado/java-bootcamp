package com.bootcamp.springboot.Service;

import com.bootcamp.springboot.Repository.IRoleRepository;
import com.bootcamp.springboot.Service.Interface.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;
}
