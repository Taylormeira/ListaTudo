package com.limaTaylor.listaTudo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_LIST")
public class ListModel {
    @Id
    private int listId;
    private int groupId;
    private String nameList;
    private int itemId;
    private float itemValue;
    private float itemQuantity;
}
