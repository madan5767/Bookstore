package com.example.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin", uniqueConstraints= {@UniqueConstraint(columnNames={"adminEmail"})})
public class Admin {
    @Id //primary key of entity bhanera janaucha
    @GeneratedValue(strategy = GenerationType.IDENTITY)//automatic primary key generation ko lagi @Geneartedvalue. link cha
    private long adminId;

    @NotEmpty
    private String adminName;

    @NotEmpty
    @Email
    private String adminEmail;

    @NotEmpty
    @Size(max = 8)
    private String adminPassword;
}
