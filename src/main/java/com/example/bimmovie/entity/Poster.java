package com.example.bimmovie.entity;

import lombok.*;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie")
@Table(name = "tbl_poster")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String fname;

    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
