package com.limaTaylor.listaTudo.Models;

import com.limaTaylor.listaTudo.Dtos.ListDto;
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
@Table(name = "TB_LIST")
public class ListModel {
    @Id
    private int listId;
    private int groupId;
    private String nameList;
    private int itemId;
    private float itemValue;
    private float itemQuantity;

    public ListModel(ListDto data) {
        this.listId = data.getListId();
        this.groupId = data.getGroupId();
        this.nameList = data.getNameList();
        this.itemId = data.getItemId();
        this.itemValue = data.getItemValue();
        this.itemQuantity = data.getItemQuantity();
    }
}
