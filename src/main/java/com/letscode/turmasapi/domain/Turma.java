package com.letscode.turmasapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "turma")
public class Turma {

    @Id
    private String id;
    private String nome;

    @Field
    private Set<Long> listaDeAlunos = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Long> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(Set<Long> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
}
