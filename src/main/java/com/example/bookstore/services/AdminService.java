package com.example.bookstore.services;

import com.example.bookstore.dao.AdminRepository;
import com.example.bookstore.mappers.LoginMapper;
import com.example.bookstore.models.Admin;
import com.example.bookstore.views.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private LoginMapper loginMapper;

    public Admin saveAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    public List<Admin> getAllAdmin(){
        return adminRepo.findAll();
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin){
        Admin existingAdmin = adminRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        existingAdmin.setAdminName(updatedAdmin.getAdminName());
        existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
        existingAdmin.setAdminPassword(updatedAdmin.getAdminPassword());
        return adminRepo.save(existingAdmin);
    }

    public Object validate(String email, String password){
        List<Admin> admins = adminRepo.getAdminByAdminEmailAndAdminPassword(email, password);
        if(admins.size() != 0){
            return loginMapper.INSTANCE.modelsToDto(admins);
        }
        else{
            return new ResponseObject(0, "Invalid email or password!");
        }

    }

    public String deleteAdminById(long id){
        adminRepo.deleteById(id);
        return "Admin ID: "+id+" is deleted";
    }

}
