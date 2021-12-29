package com.example.be_webbanhang.service;

import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.model.Role;
import com.example.be_webbanhang.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void addRole(Role role){
        Optional<Role> roleOptional =
                roleRepository.findRoleById(role.getIdRole());
        if (roleOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        roleRepository.save(role);
    }

    public void removeRole(int idRole){
        boolean exists = roleRepository.existsById(idRole);
        if (!exists) {
            throw new IllegalStateException("role with id " + idRole + " does not exists");
        }
        roleRepository.deleteById(idRole);
    }

    @Transactional
    public Role updateRole(Role role, int idRole) {
        Role role1 = this.roleRepository.findOneById(idRole);
        BeanUtils.copyProperties(role, role1);
        return roleRepository.saveAndFlush(role1);
    }
}
