package com.lcvinh.demo.screeningmovie.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningMovieResponse {

    private String id;
    private String screeningId;
    private String movieId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

}
