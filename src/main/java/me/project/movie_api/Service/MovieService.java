package me.project.movie_api.Service;

import me.project.movie_api.Repository.MovieRepository;
import me.project.movie_api.domain.Movie;
import me.project.movie_api.domain.MovieRequestDTO;
import me.project.movie_api.domain.MovieResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // GET: TODOS OS FILMES
    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(movie -> new MovieResponseDTO(movie)).toList();
    }

    // GET: FILME POR ID : UUID
    public Optional<MovieResponseDTO> getMovie(UUID id) {
        if(movieRepository.existsById(id)) {
            return movieRepository.findById(id).map(movie -> new MovieResponseDTO(movie));
        } else {
            throw new RuntimeException("Movie not found with id " + id);
        }
    }

    // POST: INSERIR FILME
    public Movie createMovie(MovieRequestDTO movieDTO) {
        Movie movie = new Movie();

        movie.setTitle(movieDTO.title());
        movie.setDescription(movieDTO.description());
        movie.setImgURL(movieDTO.imgURL());
        movie.setGenre(movieDTO.genre());
        movie.setRating(movieDTO.rating());
        movie.setMovieYear(movieDTO.movieYear());
        movie.setImdbId(movieDTO.imdbId());

        movieRepository.save(movie);

        return movie;
    }

    public String deleteMovie(UUID id) {
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return "Deletado com sucesso.";
        }
        return "Filme não encontrado";
    }

    public Movie updateMovie(UUID id, Movie movieDetails) {
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            movie.setTitle(movieDetails.getTitle());
            movie.setDescription(movieDetails.getDescription());
            movie.setGenre(movieDetails.getGenre());
            movie.setImdbId(movieDetails.getImdbId());
            movie.setImgURL(movieDetails.getImgURL());
            movie.setRating(movieDetails.getRating());
            movie.setMovieYear(movieDetails.getMovieYear());
            return movieRepository.save(movie);
        } else {
            throw new RuntimeException("Movie not found with id " + id);
        }
    }
}
