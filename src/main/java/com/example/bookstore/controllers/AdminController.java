package com.example.bookstore.controllers;

import com.example.bookstore.models.Admin;
import com.example.bookstore.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/Admin")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    public List<Admin> getAllAdmins(){
        return service.getAllAdmin();
    }

    @GetMapping("/admin/login")
    public Object loginAdmin(@RequestParam("adminEmail") String adminEmail, @RequestParam("adminPassword") String adminPassword){
        return service.validate(adminEmail, adminPassword);
    }

    @PostMapping("/saveAdmin")
    public ResponseEntity<Admin> postAdmin(@Valid @RequestBody Admin admin){
        return new ResponseEntity<Admin>(
                service.saveAdmin(admin), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAdminById/{id}")
    public String deleteAdmin(@PathVariable long id){
        return service.deleteAdminById(id);
    }

}
