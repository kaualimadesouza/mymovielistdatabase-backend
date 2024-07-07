package me.project.movie_api.domain;

import java.util.UUID;

public record MovieResponseDTO (UUID id, String title, String description, String imgURL, String genre, Integer rating, Integer movieYear, String imdbId) {

    public MovieResponseDTO(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getImgURL(), movie.getGenre(), movie.getRating(), movie.getMovieYear(), movie.getImdbId());
    }
}
