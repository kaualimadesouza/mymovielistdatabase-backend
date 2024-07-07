package me.project.movie_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "movies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private String imgURL;
    private String genre;
    private Integer rating;
    private Integer movieYear;

    @Column(name = "imdbid")
    private String imdbId;
}
