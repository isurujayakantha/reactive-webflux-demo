package com.jayk.demos.reactive.webflux.repository;

import com.jayk.demos.reactive.webflux.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

  /**
   * Find by name flux.
   *
   * @param name the name
   * @return the flux
   */
  @Query("{ 'name': ?0 }")
  Flux<Employee> findByName(final String name);
}

