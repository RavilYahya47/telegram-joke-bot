package com.ravilyahya.simpletelegrambot.service.impl;
import com.ravilyahya.simpletelegrambot.model.ChuckNorrisJoke;
import com.ravilyahya.simpletelegrambot.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChuckNorrisJokeService {

    private final ParsingService parsingService;
    private static final String url="https://api.chucknorris.io/jokes/random";

    public String getRandomJoke(){
        ChuckNorrisJoke joke =(ChuckNorrisJoke) parsingService.parseNorris(url);
        return joke.getValue();
    }
}
