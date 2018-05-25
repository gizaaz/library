package com.japs.lab5db.controller;

import com.japs.lab5db.model.Book;
import com.japs.lab5db.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static javafx.beans.binding.Bindings.when;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/get")
    public List<Book> getBook()  {
        //return buildingService.getBuildings();
        return bookRepository.findAll();
    }

    @PostMapping("/insert")
    public Book insertBook( @RequestBody Book book){
        //return buildingService.insertBuilding(book);
        return bookRepository.save(book);
    }
    @RequestMapping("/update")
    public Book updateBook(@RequestBody Book book,@RequestParam("id")int id)  {
        book.setIdBook(id);
        return bookRepository.save(book);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteBook(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        bookRepository.deleteById(id);
    }

}
