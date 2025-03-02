package com.lcvinh.demo.screeningmovie.dto.request;

import com.lcvinh.demo.movie.entity.Movie;
import com.lcvinh.demo.screening.entity.Screening;
import com.lcvinh.demo.screeningseat.ScreeningSeat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScreeningMovieRequest {

    private String screeningId;
    private String movieId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
}
