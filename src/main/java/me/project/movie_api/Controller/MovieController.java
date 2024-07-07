package me.project.movie_api.Controller;

import me.project.movie_api.Service.MovieService;
import me.project.movie_api.domain.Movie;
import me.project.movie_api.domain.MovieRequestDTO;
import me.project.movie_api.domain.MovieResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieResponseDTO>> getMovie(@PathVariable UUID id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody MovieRequestDTO movieDTO) {
        Movie createdMovie = movieService.createMovie(movieDTO);
        return ResponseEntity.created(URI.create("/movies/" + createdMovie.getId())).body(createdMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String logMovie = movieService.deleteMovie(id);
        return ResponseEntity.ok(logMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable UUID id, @RequestBody Movie movieDetails) {
        Movie updatedMovie = movieService.updateMovie(id, movieDetails);
        return ResponseEntity.ok(updatedMovie);
    }
}
