package com.projects.url_shortner.service;

import com.projects.url_shortner.encode.Base62Utils;
import com.projects.url_shortner.entity.ShortUrl;
import com.projects.url_shortner.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UrlShortenerService {
    @Autowired
    private UrlShortenerRepository repository;

    public String shortenUrl(String longUrl) {
        String shortCode = generateShortCode(longUrl);
        System.out.println(shortCode);
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setShortCode(shortCode);
        shortUrl.setLongUrl(longUrl);
//        shortUrl.setCreatedAt(LocalDateTime.now());
        repository.save(shortUrl);
        return shortCode;
    }

    public String getLongUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                         .map(ShortUrl::getLongUrl)
                         .orElseThrow(() -> new RuntimeException("URL Not Found"));
    }

    private String generateShortCode(String longUrl) {
        return Base62Utils.encode(longUrl.hashCode() & Long.MAX_VALUE);
    }
}
