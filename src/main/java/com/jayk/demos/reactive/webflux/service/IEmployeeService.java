package com.jayk.demos.reactive.webflux.service;

import com.jayk.demos.reactive.webflux.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The interface Employee service.
 */
public interface IEmployeeService {

  /**
   * Create.
   *
   * @param e the e
   */
  void create(Employee e);

  /**
   * Find by id mono.
   *
   * @param id the id
   * @return the mono
   */
  Mono<Employee> findById(Integer id);

  /**
   * Find by name flux.
   *
   * @param name the name
   * @return the flux
   */
  Flux<Employee> findByName(String name);

  /**
   * Find all flux.
   *
   * @return the flux
   */
  Flux<Employee> findAll();

  /**
   * Update mono.
   *
   * @param e the e
   * @return the mono
   */
  Mono<Employee> update(Employee e);

  /**
   * Delete mono.
   *
   * @param id the id
   * @return the mono
   */
  Mono<Void> delete(Integer id);
}
