//package com.example.bookstore.models;
//
//import com.example.bookstore.enums.ERole;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Role")
//@RequiredArgsConstructor
//@Setter
//@Getter
//public class Role {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Integer id;
//
//    @Enumerated(EnumType.STRING)
//    @Column
//    private ERole name;
//
//    public Role() {
//
//    }
//
//    public Role(ERole name) {
//        this.name = name;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public ERole getName() {
//        return name;
//    }
//
//    public void setName(ERole name) {
//        this.name = name;
//    }
//}
