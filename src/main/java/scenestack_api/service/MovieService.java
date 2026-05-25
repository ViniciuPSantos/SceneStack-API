package scenestack_api.service;

import scenestack_api.client.OmdbClient;
import scenestack_api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final OmdbClient omdbClient;

    public MovieResponseDTO searchMovie(String title){
        return omdbClient.getMovieByTitle(title);
    }

    public SerieResponseDTO searchSerie(String title){ return omdbClient.getSerieByTitle(title); }

    public SearchMovieResponseDTO searchMovies(String title, int page){
        return omdbClient.searchMovies(title, page);
    }

    public SearchSerieResponseDTO searchSeries(String title, int page) {
        return omdbClient.searchSeries(title, page);
    }

    public MovieResponseDTO getMovieByImdbId(String imdbID){ return omdbClient.getMovieByImdbId(imdbID); }

    public SerieResponseDTO getSerieByImdbId(String imdbID){ return omdbClient.getSerieByImdbId(imdbID); }

    public SearchResponseDTO search(String title, String type, int page){ return omdbClient.search(title, type, page); }

    public ItemResponseDTO searchByTitle(String title, String type){ return omdbClient.searchByTitle(title, type); }
}
