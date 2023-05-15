package com.jdbcspringbootdatabase1.springbootdatabasejdbc1.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdbcspringbootdatabase1.springbootdatabasejdbc1.models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

 

}
