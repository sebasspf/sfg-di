package guru.springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import guru.springframework.sfgdi.services.GreetingService;

@Service
public class I18nController {
	
	private final GreetingService greetingService;

	public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
	

}
