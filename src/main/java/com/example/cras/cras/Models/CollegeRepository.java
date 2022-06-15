package com.example.cras.cras.Models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends CrudRepository<College, Long> {

}
