package scenestack_api.controller;

import lombok.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import scenestack_api.dto.*;
import scenestack_api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@RestController
@Validated
@RequestMapping("/api/scenestack")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovieController {
    private final MovieService service;

    @GetMapping("/movies")
    public SearchResponseDTO searchMovies(
            @RequestParam @NotBlank(message = "Title cannot be empty.") String title,
            @RequestParam(defaultValue = "1") int page
    ){
        return service.search(title, "movie", page);
    }

    @GetMapping("/series")
    public SearchResponseDTO searchSeries(
            @RequestParam @NotBlank(message = "Title cannot be empty.") String title,
            @RequestParam(defaultValue = "1") int page
    ){
        return service.search(title, "series", page);
    }

    @GetMapping("/movie/id/{imdbId}")
    public MovieResponseDTO getMovieById(@PathVariable String imdbId){ return service.getMovieByImdbId(imdbId); }

    @GetMapping("/serie/id/{imdbId}")
    public SerieResponseDTO getSerieByID(@PathVariable String imdbId){return service.getSerieByImdbId(imdbId); }



    //pesquisa generica
    @GetMapping("/search")
    public SearchResponseDTO search(
            @RequestParam @NotBlank(message = "Title cannot be empty.") String title,
            @RequestParam @NotBlank(message = "Type cannot be empty.") String type,
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "Page must be greater than 0.") int page){

        return service.search(title, type, page);
    }

    @GetMapping("/details")
    public ItemResponseDTO details(
            @RequestParam @NotBlank(message = "Title cannot be empty.") String title,
            @RequestParam @NotBlank(message = "Type cannot be empty.") String type){

        return service.searchByTitle(title, type);
    }


}
