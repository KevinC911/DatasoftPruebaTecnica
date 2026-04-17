package com.datasoftlibrary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    private Long id;

    @Column
    private String full_name;

    @Column(unique = true)
    private String username;

    @Column
    private String passwd;

    @Column
    private String state;
}
