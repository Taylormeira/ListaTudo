package com.limaTaylor.listaTudo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_USER")
public class UserModel {
    @Id
    private int userId;
    private int groupId;
    private int familyId;
    private String userName;
    private String fullName;


    }
