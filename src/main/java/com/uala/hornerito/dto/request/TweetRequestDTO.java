package com.uala.hornerito.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TweetRequestDTO {

    @JsonProperty("user_id")
    @Min(value = 1, message = "User ID must be greater than 0")
    public int userId;

    @JsonProperty("content")
    @NotBlank(message = "Content cannot be blank")
    @Size(max = 280, message = "Max content 280 characters.")
    public String content;

}
