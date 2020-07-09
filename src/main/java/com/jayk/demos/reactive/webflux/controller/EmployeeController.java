package com.jayk.demos.reactive.webflux.controller;

import com.jayk.demos.reactive.webflux.model.Employee;
import com.jayk.demos.reactive.webflux.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Employee controller.
 */
@RestController
public class EmployeeController {

  @Autowired
  private IEmployeeService employeeService;

  /**
   * Create.
   *
   * @param e the e
   */
  @RequestMapping(value = {"/create", "/"}, method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Employee e) {
    employeeService.create(e);
  }

  /**
   * Find by id response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
    Mono<Employee> e = employeeService.findById(id);
    HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(e, status);
  }

  /**
   * Find by name flux.
   *
   * @param name the name
   * @return the flux
   */
  @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
  public Flux<Employee> findByName(@PathVariable("name") String name) {
    return employeeService.findByName(name);
  }

  /**
   * Find all flux.
   *
   * @return the flux
   */
  @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Employee> findAll() {
    return employeeService.findAll();
  }

  /**
   * Update mono.
   *
   * @param e the e
   * @return the mono
   */
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public Mono<Employee> update(@RequestBody Employee e) {
    return employeeService.update(e);
  }

  /**
   * Delete.
   *
   * @param id the id
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Integer id) {
    employeeService.delete(id).subscribe();
  }

}