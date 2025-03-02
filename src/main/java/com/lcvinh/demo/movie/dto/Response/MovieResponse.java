package com.lcvinh.demo.movie.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {
    private UUID movieId;

    private String title;

    private String genre;

    private int duration;

    private Date releaseDate;

    private String description;
}
