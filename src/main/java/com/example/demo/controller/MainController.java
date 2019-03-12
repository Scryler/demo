package com.example.demo.controller;


import com.example.demo.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {


    /*private List<Book> bookList = new ArrayList<Book>(){{
        add(new Book(1,"someTitle","someAuthor",1234,"somePublisher", "paperback",111,1123,false));
        add(new Book(2,"someTitle","someAuthor",1234,"somePublisher", "paperback",111,1123,false));
        add(new Book(3,"someTitle","someAuthor",1234,"somePublisher", "paperback",111,1123,false));
    }};
*/

    private List<Book> bookList = new ArrayList<Book>(){{
        add(new Book(1,"s"));
        add(new Book(2,"a"));
        add(new Book(3,"d"));
    }};
    @GetMapping
    public List<Book> getBooks(){
        return bookList;
    }

    @GetMapping("{id}")
    public Book getOneBook(@PathVariable int id){
        return bookList.get(id);
    }

    @PostMapping(consumes = "application/json")
    public List<Book> createBook(@RequestBody Book book){

        bookList.add(book);

        return bookList;
    }

    @PutMapping("{id}")
    public List<Book> update(@PathVariable int id, @RequestBody Book book){

        bookList.set(id,book);

        return bookList;
    }

    @DeleteMapping("{id}")
    public List<Book> delete(@PathVariable int id){

        bookList.remove(id);

        return bookList;

    }

    @DeleteMapping(consumes = "application/json")
    public List<Book> delete(@RequestBody Book book){

        bookList.remove(book);

        return bookList;
    }

}
