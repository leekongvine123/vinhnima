package com.lcvinh.demo.movie.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieCreationRequest {
    private String title;
    private String genre;
    private int duration;
    private Date releaseDate;
    private String description;
}