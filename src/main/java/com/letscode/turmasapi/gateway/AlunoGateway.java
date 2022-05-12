package com.letscode.turmasapi.gateway;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlunoGateway {

    private final RestTemplate restTemplate;

    public AlunoGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> getAluno(Long id) {
        String url = String.format("http://alunos-mysql-app-instance:8080/aluno/%s", id);
        return restTemplate.getForEntity(url,String.class);
    }
}
