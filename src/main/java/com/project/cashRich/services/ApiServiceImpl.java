package com.project.cashRich.services;

import com.project.cashRich.model.Api3dParty;
import com.project.cashRich.model.User;
import com.project.cashRich.repository.ApiRequestRepository;
import com.project.cashRich.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

/**
 * @author Nehal Ansari
 */
@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements Api3dService {
    private final String baseUrl = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
    private final ApiRequestRepository apiRequestRepository;
    private final RestTemplate restTemplate;

    private final UserRepository userRepository;

    public Api3dParty consumeApi(String symbol) {
        HttpEntity<Void> httpEntity  = new HttpEntity<>(gethttpHeaders());
        String url = buildUrlWithParams(symbol);

        ResponseEntity<Api3dParty> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Api3dParty.class);
        if (response.getStatusCode() == HttpStatus.OK) {

            Api3dParty apiRequest = new Api3dParty();
//            apiRequest.setUserId(user.getId());
            apiRequest.setRequest(baseUrl);
            apiRequest.setResponse(response.getStatusCode().toString());
            apiRequest.setTimestamp(LocalDateTime.now());
            apiRequestRepository.save(apiRequest);
        } else {
            throw new RuntimeException("Failed to make API request: " + response.getStatusCode());
        }
        Api3dParty body = response.getBody();
        return body;
    }
    private HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-CMC_PRO_API_KEY", "27ab17d1-215f-49e5-9ca4-afd48810c149");
        return headers;
    }
    private String buildUrlWithParams(String symbol) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("symbol", symbol)
                .toUriString();
    }

//    @Override
//    public void makeApiRequest(Long userId) {
//        String apiUrl = "https://proapi.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-CMC_PRO_API_KEY", "27ab17d1-215f-49e5-9ca4-afd48810c149");
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<Api3dParty> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Api3dParty.class);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            Api3dParty apiRequest = new Api3dParty();
//            apiRequest.setUserId(userId);
//            apiRequest.setRequest(apiUrl);
////            apiRequest.setResponse(response.getBody());
//            apiRequest.setTimestamp(LocalDateTime.now());
//            apiRequestRepository.save(apiRequest);
//        } else {
//            throw new RuntimeException("Failed to make API request: " + response.getStatusCode());
//        }
//    }


}

