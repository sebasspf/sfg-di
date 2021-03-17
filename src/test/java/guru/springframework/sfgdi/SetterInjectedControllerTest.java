package guru.springframework.sfgdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.controllers.SetterInjectedController;
import guru.springframework.sfgdi.services.ConstructorGreetingService;

class SetterInjectedControllerTest {

	private SetterInjectedController controller;
	
	@BeforeEach
	void setUp() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new ConstructorGreetingService());
	}
	
	@Test
	void test() {
		System.out.println(controller.getGreeting());
	}

}
