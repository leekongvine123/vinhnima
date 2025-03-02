package com.lcvinh.demo.screeningseat;

import com.lcvinh.demo.entity.BaseEntity;
import com.lcvinh.demo.seat.Seat;
import com.lcvinh.demo.screeningmovie.entity.ScreeningMovie;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreeningSeat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID screeningSeatId;

    @ManyToOne
    @JoinColumn(name = "screening_movie_id", nullable = false)
    private ScreeningMovie screeningMovie;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(length = 20, nullable = false)
    private String status; // Available, Booked
}
