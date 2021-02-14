package com.bootcamp.springboot.Repository;

import com.bootcamp.springboot.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoJpaRepository extends JpaRepository<ToDo, Long> {
}
