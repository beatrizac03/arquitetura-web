package com.mvc.tarefas.repository;

import com.mvc.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.MongoRepository;

public interface TarefaMongoRepository extends MongoRepository<Tarefa, String> {
}
