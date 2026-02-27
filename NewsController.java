package com.example.news.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.news.dto.ArticleDto;
import com.example.news.dto.NewsApiResponse;

@RestController
public class NewsController {

    private final RestTemplate restTemplate;
    private final String newsApiKey;

    public NewsController(RestTemplate restTemplate, @Value("${newsapi.key}") String newsApiKey) {
        this.restTemplate = restTemplate;
        this.newsApiKey = newsApiKey;
    }

    @GetMapping("/api/darts-news")
    // results stored at http://localhost:8080/api/darts-news;
    public ResponseEntity<?> fetchDartsNews() {
        String url =
        "https://newsapi.org/v2/everything"
      + "?q=darts"
      + "&sources=espn,bbc-sport,talksport,sky-sports"
      + "&sortBy=publishedAt"
      + "&language=en"
      + "&apiKey=" + newsApiKey;
        try {
            // Map response to NewsApiResponse
            NewsApiResponse apiResponse = restTemplate.getForObject(url, NewsApiResponse.class);

            if (apiResponse == null || !"ok".equals(apiResponse.getStatus())) {
                return ResponseEntity.status(502).body("{\"error\":\"Invalid response from news API\"}");
            }

            // Take top 5 articles
            List<ArticleDto> topArticles = apiResponse.getArticles().stream()
                    .limit(5)
                    .map(a -> new ArticleDto(a.getTitle(), a.getUrl(), a.getPublishedAt()))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(topArticles);

        } catch (RestClientException e) {
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch news\"}");
        }
    }
}