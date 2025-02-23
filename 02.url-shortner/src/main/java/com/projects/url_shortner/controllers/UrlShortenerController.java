package com.projects.url_shortner.controllers;

import com.projects.url_shortner.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    @Autowired
    private UrlShortenerService service;

    @PostMapping(value = "/shorten", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Map<String, Object>> shortenUrl(@RequestBody Map<String, String> request) {
        String shortUrl = service.shortenUrl(request.get("longUrl"));
        System.out.println(shortUrl);

        Map<String,Object> response = new HashMap<>();
        response.put("shortUrl", "https://short.ly/" + shortUrl);
        response.put("longUrl", request.get("longUrl"));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode, HttpServletResponse response) throws IOException {
        String longUrl = service.getLongUrl(shortCode);
        response.sendRedirect(longUrl);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}
