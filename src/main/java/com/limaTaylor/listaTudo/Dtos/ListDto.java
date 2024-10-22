package com.limaTaylor.listaTudo.Dtos;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class ListDto {
    private @NotBlank @NotNull int listId;
    private @NotBlank @NotNull int groupId;
    private @NotNull String nameList;
    private @Nullable int itemId;
    private @Nullable float itemQuantity;
    private @Nullable float itemValue;
}
