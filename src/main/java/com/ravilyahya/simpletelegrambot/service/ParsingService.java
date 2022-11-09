package com.ravilyahya.simpletelegrambot.service;


public interface ParsingService {
    Object parseNorris(String url);
    Object parseJokeApi(String url);

    Object parseDadJoke(String url);

    Object parseAppSpotJoke(String url);
}
