package com.datasoftlibrary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Books {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String summary;

    @Column
    private BigDecimal price;

    @Column
    private String state;

    @Column
    private String image;

    @OneToOne
    @JoinColumn(name = "gen_id", referencedColumnName = "id")
    private Genres genre;

    @OneToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "id")
    private User user;
}
