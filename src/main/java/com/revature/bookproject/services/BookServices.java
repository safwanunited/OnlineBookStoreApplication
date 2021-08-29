package com.revature.bookproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.revature.bookproject.model.Books;
import com.revature.bookproject.repository.BookJpaRepository;

@Service
public class BookServices {
	@Autowired
	private  BookJpaRepository bookJpaRepository;
	
	
	
	
	public String saveBook(Books b)
	{
		bookJpaRepository.save(b);
		return "Inserted"+b.getBookName();
	}

	
	public List<Books> displayBooks()
	{
		return bookJpaRepository.findAll();
	}
	
	
	public List<Books> displayBooksPattern(String p)
	{
		String pattern="%"+p+"%";
		return bookJpaRepository.findAllByAuthorNameLike(pattern);
	}
	
	
	public List<Books> sortBooks()
	{
		return bookJpaRepository.findAll(Sort.by(Sort.Direction.ASC, "bookName"));
	}
	
	
	
	
	public Books displayBookByName(String name)
	{
		return bookJpaRepository.findByBookName(name);
	}

	
	
	public List<Books> displayBooksByAuthorName(String author)
	{
	   List<Books> list=  bookJpaRepository.findAllByAuthorName(author);  
	   return list;
	}
	
	 
	public List<Books> displayBooksByRange(int range){
		List<Books> list=  bookJpaRepository.findAllByRange(range);  
		return list;
	}
	
	public List<Books> displayBooksByGenre(String genre)
	{
	   List<Books> list=  bookJpaRepository.findAllByGenre(genre);  
	   return list;
	}
	
	
	public Books displayBookById(Long id)
	{
		return bookJpaRepository.findById(id).orElse(null);
		
	}
	
	public Books reduceStock(Long id,int quantity)
	{
		//Books book=displayBookById(id);
		 Books existingProduct = bookJpaRepository.findById(id).orElse(null);
	        existingProduct.setStock( existingProduct.getStock()-quantity);
	       
	        return bookJpaRepository.save(existingProduct);
	}
	
	public Books addStock(Long id,int quantity)
	{
		//Books book=displayBookById(id);
		 Books existing = bookJpaRepository.findById(id).orElse(null);
	        existing.setStock(existing.getStock()+quantity);
	       
	        return bookJpaRepository.save(existing);
	}
	
	
	public String deleteBookById(Long id)
	{
		 bookJpaRepository.deleteById(id);
		 return "Book id"+id+" is removed";
	}
	
	
}
