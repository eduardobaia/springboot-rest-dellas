package com.dellas.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dellas.app.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

	List<Task> findByNameOrId(String name, Long id);
}
