package scenestack_api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class ItemResponseDTO {
    @JsonAlias("Title")
    private String title;

    @JsonAlias("Year")
    private String year;

    @JsonAlias("Poster")
    private String poster;

    @JsonAlias("imdbID")
    private String imdbID;

    @JsonAlias("Type")
    private String type;
}