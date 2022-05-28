package com.letscode.turmasapi.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "alunos-service")
public interface AlunoFeignClient {

    @GetMapping(value = "/aluno/{alunoId}")
    ResponseEntity<String> getAluno(@PathVariable("alunoId") Long alunoId);
}
