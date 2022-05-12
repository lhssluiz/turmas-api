package com.letscode.turmasapi.repository;

import com.letscode.turmasapi.domain.Turma;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurmaRepository extends MongoRepository<Turma, String> {
}
