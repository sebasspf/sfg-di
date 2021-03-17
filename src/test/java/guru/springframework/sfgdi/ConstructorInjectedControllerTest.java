package guru.springframework.sfgdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.services.ConstructorGreetingService;

class ConstructorInjectedControllerTest {

	private ConstructorInjectedController controller;
	
	@BeforeEach
	void setUp() {
		controller = new ConstructorInjectedController(new ConstructorGreetingService());
	}
	
	@Test
	void test() {
		System.out.println(controller.getGreeting());
	}

}
