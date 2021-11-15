package com.pearson.demoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class GreetingController {


	@Autowired
	private BookRepository repository;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			model.addAttribute("ip", ip);
		} catch (UnknownHostException e) {
			return "error occurred while retrieving IP address.";
		}

		Iterable result = repository.findAll();
		Iterator<Book> iterator = result.iterator();
		ArrayList books = new ArrayList<Book>();
		while(iterator.hasNext()) {
			Book book = (Book) iterator.next();
			books.add(book);
		}
		model.addAttribute("books", books);
		return "greeting";
	}

	@GetMapping("/load")
	public String load() {
		repository.save(new Book("Java"));
		repository.save(new Book("Node"));
		repository.save(new Book("Python"));

		return "loaded";
	}

}
