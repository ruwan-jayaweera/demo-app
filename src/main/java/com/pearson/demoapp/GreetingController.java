package com.pearson.demoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			model.addAttribute("ip", ip);
		} catch (UnknownHostException e) {
			return "error occurred while retrieving IP address.";
		}

		return "greeting";
	}

}
