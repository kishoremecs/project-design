package com.projects.url_shortner.repository;

import com.projects.url_shortner.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UrlShortenerRepository extends JpaRepository<ShortUrl, Long> {
    
    // Find by shortCode
    Optional<ShortUrl> findByShortCode(String shortCode);
    
    // Check if a long URL already exists (optional optimization)
    Optional<ShortUrl> findByLongUrl(String longUrl);
}
