package com.letscode.turmasapi.domain;

public class TurmaAlunoRequest {
    private String idTurma; // idTurma -> camelCase
    private Long idAluno; // idAluno -> camelCase

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }
}
