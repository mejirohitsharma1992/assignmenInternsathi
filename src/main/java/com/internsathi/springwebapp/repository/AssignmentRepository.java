package com.internsathi.springwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internsathi.springwebapp.model.Assignments;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignments, Long>{

}
