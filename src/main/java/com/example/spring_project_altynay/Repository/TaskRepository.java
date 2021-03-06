package com.example.spring_project_altynay.Repository;

import com.example.spring_project_altynay.db.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task,Long> {
}
