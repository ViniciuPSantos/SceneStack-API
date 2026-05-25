package scenestack_api.client;

import scenestack_api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class OmdbClient {

    private final WebClient client;

    @Value("${omdb.api.url}")
    private String apiUrl;

    @Value("${omdb.api.key}")
    private String apiKey;

    public MovieResponseDTO getMovieByTitle(String title){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("apikey", apiKey)
                        .queryParam("t", title)
                        .build())
                .retrieve()
                .bodyToMono(MovieResponseDTO.class)
                .retry(3)
                .block();
    }

    public SerieResponseDTO getSerieByTitle(String title){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("apikey", apiKey)
                        .queryParam("t", title)
                        .queryParam("type", "series")
                        .build())
                .retrieve()
                .bodyToMono(SerieResponseDTO.class)
                .retry(3)
                .block();
    }

    public MovieResponseDTO getMovieByImdbId(String imdbId) {
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("apikey", apiKey)
                        .queryParam("i", imdbId)
                        .build())
                .retrieve()
                .bodyToMono(MovieResponseDTO.class)
                .retry(3)
                .block();
    }

    public SerieResponseDTO getSerieByImdbId(String imdbId){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("apikey", apiKey)
                        .queryParam("i", imdbId)
                        .build())
                .retrieve()
                .bodyToMono(SerieResponseDTO.class)
                .retry(3)
                .block();
    }

    public SearchResponseDTO search(String title, String type, int page){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("apikey", apiKey)
                        .queryParam("s", title)
                        .queryParam("type", type)
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(SearchResponseDTO.class)
                .retry(3)
                .block();
    }

    public ItemResponseDTO searchByTitle(String title, String type){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("apikey", apiKey)
                        .queryParam("t", title)
                        .queryParam("type", type)
                        .build())
                .retrieve()
                .bodyToMono(ItemResponseDTO.class)
                .retry(3)
                .block();
    }


}
