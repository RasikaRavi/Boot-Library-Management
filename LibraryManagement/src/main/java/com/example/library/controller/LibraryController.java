package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepository;



@Controller
public class LibraryController {
	
	@Autowired	
	LibraryRepository repo;
	
	@RequestMapping("/saveBook")
	@ResponseBody
	public List<Library> addBook(@RequestParam int id, @RequestParam int quantity, @RequestParam String bookName, @RequestParam String genre)
	{
		Library lib = new Library();
		lib.setId(id);
		lib.setQuantity(quantity);
		lib.setBookName(bookName);
		lib.setGenre(genre);
		repo.save(lib);
		
		return repo.displayBook(id);
	}
	
	@RequestMapping("/editBook")
	@ResponseBody
	public List<Library> getEditBook(@RequestParam int id)
	{
		return repo.displayBook(id);
	}
	
	@RequestMapping("/deleteBook")
	@ResponseBody
	public List<Library> getDeleteBook(@RequestParam int id) 
	{
	      repo.deleteById(id);
	      return repo.displayBook(id);
	}
	
	@RequestMapping("/getBooks")
	@ResponseBody
	public List<Library> getBooks()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/getByType")
	public ResponseEntity<Optional<Library>> getBookNameType(@RequestParam String genre)
	{
		return new ResponseEntity<Optional<Library>>(repo.findBygenreLike("%"+genre+"%"),HttpStatus.OK);
	}
	
	


	
	
	
	

}
