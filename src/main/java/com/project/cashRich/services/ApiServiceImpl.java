package com.project.cashRich.services;

// ApiServiceImpl.java
import com.project.cashRich.model.Api3dParty;
import com.project.cashRich.repository.ApiRequestRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
/**
 * @author Nehal Ansari
 */
@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements Api3dService {

    private final ApiRequestRepository apiRequestRepository;
    private final RestTemplate restTemplate;

    @Override
    public void makeApiRequest(Long userId) {
        String apiUrl = "https://proapi.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", "27ab17d1-215f-49e5-9ca4-afd48810c149");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Api3dParty apiRequest = new Api3dParty();
            apiRequest.setUserId(userId);
            apiRequest.setRequest(apiUrl);
            apiRequest.setResponse(response.getBody());
            apiRequest.setTimestamp(LocalDateTime.now());
            apiRequestRepository.save(apiRequest);
        } else {
            throw new RuntimeException("Failed to make API request: " + response.getStatusCode());
        }
    }
}

