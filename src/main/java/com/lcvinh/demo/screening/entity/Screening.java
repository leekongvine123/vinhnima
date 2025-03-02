package com.lcvinh.demo.screening.entity;

import com.lcvinh.demo.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "screening")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screening extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID screeningId;

    private String name;

    private String status;
}
