package com.lcvinh.demo.movie.entity;

import com.lcvinh.demo.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID movieId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String genre;

    private int duration;

    private Date releaseDate;

    @Column(length = 500)
    private String description;
}
