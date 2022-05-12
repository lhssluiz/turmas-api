package com.letscode.turmasapi.controller;

import com.letscode.turmasapi.domain.Turma;
import com.letscode.turmasapi.domain.TurmaAlunoRequest;
import com.letscode.turmasapi.gateway.AlunoGateway;
import com.letscode.turmasapi.repository.TurmaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(path = "/turma")
public class TurmaController {

    private final TurmaRepository turmaRepository;
    private final AlunoGateway alunoGateway;

    public TurmaController(TurmaRepository turmaRepository, AlunoGateway alunoGateway) {
        this.turmaRepository = turmaRepository;
        this.alunoGateway = alunoGateway;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Turma> addNewTurma(@RequestBody Turma turma) {
        Turma persistedTurma = this.turmaRepository.save(turma);

        return ResponseEntity
                .created(URI.create(String.format("/turma/%s", persistedTurma.getId())))
                .body(persistedTurma);
    }

    @PutMapping(path = "/add-aluno")
    public ResponseEntity<Turma> addAlunoToTurma(@RequestBody TurmaAlunoRequest turmaAlunoRequest) {
        // Buscar a turma no repositorio
        Optional<Turma> turma = this.turmaRepository.findById(turmaAlunoRequest.getIdTurma());

        if (turma.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        // Buscar aluno na outra api.
        ResponseEntity<String> responseAluno = alunoGateway.getAluno(turmaAlunoRequest.getIdAluno());

        if (!responseAluno.getStatusCode().equals(HttpStatus.OK)) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        // Estou com um uma turma válida e um aluno válido, logo posso adicionar o aluno na turma.
        Set<Long> ids = turma.get().getListaDeAlunos();
        ids.add(turmaAlunoRequest.getIdAluno());
        turma.get().setListaDeAlunos(ids);
        this.turmaRepository.save(turma.get());

        return ResponseEntity.ok(turma.get());

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Turma> getTurma(@PathVariable String id) {
        Optional<Turma> turma = this.turmaRepository.findById(id);

        if (turma.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turma.get());
    }

}
