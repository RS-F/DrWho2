package com.wildcodeschool.DrWho2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Controller
@SpringBootApplication
public class DrWho2Application {

	public static void main(String[] args) {
		SpringApplication.run(DrWhoApplication.class, args);
	}

	@RequestMapping("/doctor/{incarnation_number}")
	@ResponseBody
	public String index1(@PathVariable String incarnation_number) {
		Integer incarnation_number_int = Integer.parseInt(incarnation_number);
		String retString = "number: " + incarnation_number + " name: ";
		switch (incarnation_number_int) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
//			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See other..."); 
			retString = "See other...";
			break;
		case 9:
			retString += "Christopher Eccleston";
			break;
		case 10:
			retString += "David Tennant";
			break;
		case 11:
			retString += "Matt Smith";
			break;
		case 12:
			retString += "Peter Capaldi";
			break;
		case 13:
			retString += "Jodie Whittaker";
			break;
		default:
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//					"Impossible to retrieve the incarnation " + incarnation_number); 
			retString = "Impossible to retrieve the incarnation " + incarnation_number;
			break;
		}
		if (incarnation_number_int <= 8 && incarnation_number_int >= 1)
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See other..."); 
		if (incarnation_number_int > 13 || incarnation_number_int < 1)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Impossible to retrieve the incarnation " + incarnation_number); 
					
		return retString;
	}
}
