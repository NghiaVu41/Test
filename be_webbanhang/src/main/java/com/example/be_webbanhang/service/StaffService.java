package com.example.be_webbanhang.service;

import com.example.be_webbanhang.model.Staff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.be_webbanhang.repository.StaffRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    public List<Staff> findAll(){
        return staffRepository.findAll();
    }

    public void addStaff(Staff staff){
        Optional<Staff> staffOptional =
                staffRepository.findStaffById(staff.getIdStaff());
        if (staffOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        staffRepository.save(staff);
    }

    public void removeStaff(int idStaff){
        boolean exists = staffRepository.existsById(idStaff);
        if (!exists) {
            throw new IllegalStateException("role with id " + idStaff + " does not exists");
        }
        staffRepository.deleteById(idStaff);
    }

    @Transactional
    public Staff updateStaff(Staff staff, int idStaff) {
        Staff staff1 = this.staffRepository.findOneById(idStaff);
        BeanUtils.copyProperties(staff, staff1);
        return staffRepository.saveAndFlush(staff1);
    }
}
