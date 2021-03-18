package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import com.springframework.pets.PetService;

@Controller
public class PetController {
	private PetService petService;

	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}
	
	public String getSound() {
		return petService.getPetType();
	}
}
