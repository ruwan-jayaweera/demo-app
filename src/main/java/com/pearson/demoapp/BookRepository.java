package com.pearson.demoapp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<com.pearson.demoapp.Book, Long> {

    List<com.pearson.demoapp.Book> findByName(String name);

}
