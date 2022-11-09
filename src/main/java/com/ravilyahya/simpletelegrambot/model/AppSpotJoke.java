package com.ravilyahya.simpletelegrambot.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
public class AppSpotJoke {
    private float id;
    private String type;
    private String setup;
    private String punchline;
}
