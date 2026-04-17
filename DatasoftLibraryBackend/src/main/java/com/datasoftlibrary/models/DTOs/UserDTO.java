package com.datasoftlibrary.models.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    @Positive
    private Long id;

    @NotBlank
    private String full_name;

    @NotBlank
    private String username;

    @NotBlank
    private String passwd;

    @NotBlank
    private String state;
}
