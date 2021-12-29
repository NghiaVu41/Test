package com.example.be_webbanhang.controller;


import com.example.be_webbanhang.model.CategoryProduct;
import com.example.be_webbanhang.model.Staff;
import com.example.be_webbanhang.repository.StaffRepository;
import com.example.be_webbanhang.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin("*")
public class StaffController {

    private final StaffService staffService;
    private final StaffRepository staffRepository;

    @Autowired
    public StaffController(StaffService staffService, StaffRepository staffRepository) {
        this.staffService = staffService;
        this.staffRepository = staffRepository;
    }

    @GetMapping("/findAll")
    public List<Staff> findAll(){
        return staffService.findAll();
    }

    @GetMapping("/findStaffById/{id}")
    public Staff findStaffById(@PathVariable("id") int idStaff){
        return staffRepository.findOneById(idStaff);
    }

    @PostMapping("/findStaffUsPw/{username}/{password}")
    public Staff findStaffUsPw(@PathVariable("username") String username,@PathVariable("password") String password ){
        return staffRepository.findStaffByUsPw(username,password);
    }

    @PostMapping("/addStaff")
    public void addStaff(@RequestBody Staff staff){
        staffService.addStaff(staff);
    }

    @DeleteMapping("/deleteStaff/{id}")
    public void deleteStaff(@PathVariable("id") int idStaff) {
        staffService.removeStaff(idStaff);
    }

    @PutMapping("/updateStaff/{id}")
    public Staff updateStaff(@RequestBody Staff staff,
                             @PathVariable("id") int idStaff) {
        return staffService.updateStaff(staff, idStaff);
    }
}
