package com.datasoftlibrary.models.DTOs;

import com.datasoftlibrary.models.Genres;
import com.datasoftlibrary.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBookDTO {

    private Long id;

    private String name;

    private String summary;

    private BigDecimal price;

    private String state;

    private String image;

    private Genres genre;

    private User user;
}
