package me.project.movie_api.domain;

public record MovieRequestDTO(String title, String description, String imgURL, String genre, Integer rating, Integer movieYear, String imdbId) {

}
