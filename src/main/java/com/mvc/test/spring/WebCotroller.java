package com.mvc.test.spring;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebCotroller {
	
	@GetMapping("/playagame")
	public String playGame(@RequestParam(name="choice", required=false) String theChoice, Model model) {
		
		String theOutcome = "error";
		Random rand = new Random();
		int value = rand.nextInt(3);
		//Computer 0=rock, 1=paper, 2=scissors
		
		if (theChoice.equals("rock")) {
			if(value==0) {
			theOutcome = "You chose: rock | Computer chose: rock | Result: tie";
			}
			if(value==1) {
			theOutcome = "You chose: rock | Computer chose: paper | Result: loss";	
			}
			if(value==2) {
			theOutcome = "You chose: rock | Computer chose: scissors | Result: win";	
			}
			
		} else if(theChoice.equals("paper")) {
			if(value==0) {
			theOutcome = "You chose: paper | Computer chose: rock | Result: win";
			}
			if(value==1) {
			theOutcome = "You chose: paper | Computer chose: paper | Result: tie";	
			}
			if(value==2) {
			theOutcome = "You chose: paper | Computer chose: scissors | Result: loss";	
			}
		} else if(theChoice.equals("scissors")){
			if(value==0) {
			theOutcome = "You chose: scissors | Computer chose: rock | Result: loss";
			}
			if(value==1) {
			theOutcome = "You chose: scissors | Computer chose: paper | Result: win";	
			}
			if(value==2) {
			theOutcome = "You chose: scissors | Computer chose: scissors | Result: tie";	
			}
		}
		
		model.addAttribute("outcome", theOutcome);
		
		return "result";
	}

}
