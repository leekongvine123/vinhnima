package com.lcvinh.demo.screeningmovie.entity;

import com.lcvinh.demo.screeningseat.ScreeningSeat;
import com.lcvinh.demo.movie.entity.Movie;
import com.lcvinh.demo.screening.entity.Screening;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screening_movie")
@Builder
public class ScreeningMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @OneToMany(mappedBy = "screeningMovie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScreeningSeat> screeningSeats = new ArrayList<>();

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status;
}
