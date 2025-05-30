package amielcyber.petsearch.api.request;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

@Data
public class PetParamsRequest {
    @NotEmpty
    @Pattern(regexp = "(?:dog|cat)$", message = "Only types: 'cat' and dog are supported.")
    private String type;

    @NotEmpty
    @Pattern(regexp = "^\\d{5}$", message = "Zip Code must be 5 digits.")
    private String location;

    @Min(value = 1, message = "Page must be greater than 0.")
    private int page = 1;

    @Range(min = 1, max = 500, message = "Distance must be between 0-500")
    private int distance = 25;

    @Pattern(regexp = "^-?(recent|distance)$", message = "Only location values: 'recent' and 'distance' with optional '-' prefix are accepted.")
    private String sort = "distance";
}
