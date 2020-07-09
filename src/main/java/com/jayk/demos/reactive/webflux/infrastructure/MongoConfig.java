package com.jayk.demos.reactive.webflux.infrastructure;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * The type Mongo config.
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.jayk.demos.reactive.webflux")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

  @Value("${port}")
  private String port;

  @Value("${dbname}")
  private String dbName;

  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return dbName;
  }

  /**
   * Reactive mongo template reactive mongo template.
   *
   * @return the reactive mongo template
   */
  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
  }
}