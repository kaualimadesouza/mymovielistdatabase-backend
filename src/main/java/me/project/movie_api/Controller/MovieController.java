package me.project.movie_api.Controller;

import jakarta.websocket.server.PathParam;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/pageable/{page}/{size}")
    public ResponseEntity<List<MovieResponseDTO>> getMoviesPageable(@PathVariable int page, @PathVariable int size) {
        List<MovieResponseDTO> moviePageable = movieService.getMoviesPageable(page, size);
        if(!moviePageable.isEmpty()) {
            return ResponseEntity.ok(moviePageable);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/search/{movie}/{page}/{size}")
    public ResponseEntity<List<MovieResponseDTO>> getMoviesbyName(@PathVariable int page, @PathVariable int size, @PathVariable String movie) {
        List<MovieResponseDTO> moviePageable = movieService.getMoviesByMovieName(movie, page, size);
        if(!moviePageable.isEmpty()) {
            return ResponseEntity.ok(moviePageable);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieResponseDTO>> getMovie(@PathVariable UUID id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody MovieRequestDTO movieDTO) {
        Movie createdMovie = movieService.createMovie(movieDTO);
        return ResponseEntity.created(URI.create("/movies/" + createdMovie.getId())).body(createdMovie);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String logMovie = movieService.deleteMovie(id);
        return ResponseEntity.ok(logMovie);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable UUID id, @RequestBody Movie movieDetails) {
        Movie updatedMovie = movieService.updateMovie(id, movieDetails);
        return ResponseEntity.ok(updatedMovie);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/all")
    public ResponseEntity<String> insertListMovies(@RequestBody List<MovieRequestDTO> listMovies) {
        if (!listMovies.isEmpty()) {
            movieService.insertMovies(listMovies);
            return ResponseEntity.ok("Inserido com sucesso");
        }
        return ResponseEntity.notFound().build();
    }
}
