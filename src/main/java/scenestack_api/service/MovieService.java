package scenestack_api.service;

import org.springframework.cache.annotation.Cacheable;
import scenestack_api.client.OmdbClient;
import scenestack_api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final OmdbClient omdbClient;

    @Cacheable("movie-imdbID")
    public MovieResponseDTO getMovieByImdbId(String imdbID){ return omdbClient.getMovieByImdbId(imdbID); }

    @Cacheable("serie-imdbID")
    public SerieResponseDTO getSerieByImdbId(String imdbID){ return omdbClient.getSerieByImdbId(imdbID); }

    @Cacheable("generic-search")
    public SearchResponseDTO search(String title, String type, int page){ return omdbClient.search(title, type, page); }

    @Cacheable("generic-details")
    public ItemResponseDTO searchByTitle(String title, String type){ return omdbClient.searchByTitle(title, type); }
}
