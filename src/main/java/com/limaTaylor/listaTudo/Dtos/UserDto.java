package com.limaTaylor.listaTudo.Dtos;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
   private @NotBlank @NotNull int userId;
   private @NotNull int groupId;
   private @NotNull int familyId;
   private @NotNull String userName;
   private @Nullable String fullName;
}
