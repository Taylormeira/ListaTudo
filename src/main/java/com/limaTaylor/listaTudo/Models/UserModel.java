package com.limaTaylor.listaTudo.Models;

import com.limaTaylor.listaTudo.Dtos.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USER")
public class UserModel {
    @Id
    private int userId;
    private int groupId;
    private int familyId;
    private String userName;
    private String fullName;

    public UserModel(UserDto data) {
        this.userId = data.getUserId();
        this.groupId = data.getGroupId();
        this.familyId = data.getFamilyId();
        this.userName = data.getUserName();
        this.fullName = data.getFullName();
    }
}
