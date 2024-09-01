package com.uala.hornerito.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TweetDTO {

    @JsonProperty("id")
    public int id;

    @JsonProperty("user_id")
    public String userId;

    @JsonProperty("content")
    public String content;

    @JsonProperty("datetime")
    public Timestamp datetime;

}
