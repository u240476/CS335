package com.example.news.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
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
    public ResponseEntity<?> fetchDartsNews() {
        String query = "darts AND sport OR PDC OR League OR World OR Open OR Championship OR Series";
        String url;
        try {
            url = "https://newsapi.org/v2/everything"
                    + "?q=" + URLEncoder.encode(query, "UTF-8")
                    + "&sortBy=publishedAt"
                    + "&language=en"
                    + "&apiKey=" + newsApiKey;
        } catch (UnsupportedEncodingException e) {
            return ResponseEntity.status(500).body("{\"error\":\"Encoding failed\"}");
        }

        try {
            NewsApiResponse apiResponse = restTemplate.getForObject(url, NewsApiResponse.class);

            if (apiResponse == null || !"ok".equals(apiResponse.getStatus()) || apiResponse.getArticles() == null) {
                return ResponseEntity.status(502).body("{\"error\":\"Invalid response from news API\"}");
            }

            // Block articles containing these words
            List<String> blockedKeywords = Arrays.asList("politics", "football", "soccer", "judiciary");

            // Filter first, then take top 5
            List<ArticleDto> filteredTopArticles = apiResponse.getArticles().stream()
                    .filter(a -> a.getTitle() != null)
                    .filter(a -> blockedKeywords.stream()
                     .noneMatch(word -> 
                    (a.getTitle() != null && a.getTitle().toLowerCase().contains(word.toLowerCase()))
                     || (a.getDescription() != null && a.getDescription().toLowerCase().contains(word.toLowerCase()))
    )
)
                    .limit(5)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(filteredTopArticles);

        } catch (RestClientException e) {
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch news\"}");
        }
    }
}