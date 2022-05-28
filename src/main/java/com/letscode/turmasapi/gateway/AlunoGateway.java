package com.letscode.turmasapi.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AlunoGateway {

    private final AlunoFeignClient alunoFeignClient;

    public ResponseEntity<String> getAluno(Long id) {
        // Busca no eureka server qual instância/container devo chamar, baseado no nome
        // do serviço que eu coloquei lá na especificação do feign.
        return alunoFeignClient.getAluno(id);
//        String url = String.format("http://alunos-mysql-app-instance:8080/aluno/%s", id);
    }
}
