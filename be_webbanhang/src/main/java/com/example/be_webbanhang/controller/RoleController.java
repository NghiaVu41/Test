package com.example.be_webbanhang.controller;

import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.model.Role;
import com.example.be_webbanhang.repository.RoleRepository;
import com.example.be_webbanhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/findAll")
    public List<Role> findAll(){
        return roleService.findAll();
    }

    @GetMapping("/findRoleById/{id}")
    public Role findRoleById(@PathVariable("id") int idRole){
        return roleRepository.findOneById(idRole);
    }

    @PostMapping("/addRole")
    public void addRole(@RequestBody Role role){
        roleService.addRole(role);
    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable("id") int idRole ) {
        roleService.removeRole(idRole);
    }

    @PutMapping("/updateRole/{id}")
    public Role updateCategoryProduct(@RequestBody Role role,@PathVariable("id") int idRole) {
        return roleService.updateRole(role, idRole);
    }
}
