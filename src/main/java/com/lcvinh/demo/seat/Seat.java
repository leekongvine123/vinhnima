package com.lcvinh.demo.seat;

import com.lcvinh.demo.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "seat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID seatId;

    @Column(length = 5, nullable = false)
    private String rowName;

    private int seatNumber;
}

