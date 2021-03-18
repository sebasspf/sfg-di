package guru.springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.pets.DogPetService;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.I18nSpanishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyGreetingService;
import guru.springframework.sfgdi.services.SetterGreetingService;

@Configuration
public class GreetingServiceConfig {
	
	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}
	
	@Profile({"dog", "default"})
	@Bean
	PetService dogPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("dog");
	}
	
	@Profile("cat")
	@Bean
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("cat");
	}
	
	@Profile({"ES", "default"})
	@Bean("i18nService")
	I18nSpanishGreetingService i18nSpanishGreetingService() {
		return new I18nSpanishGreetingService();
	}
	
	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}
	
	@Profile("EN")
	@Bean("i18nService")
	I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRespository) {
		return new I18nEnglishGreetingService(englishGreetingRespository);
	}
	
	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}
	
	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}
	
	@Bean
	PropertyGreetingService propertyGreetingService() {
		return new PropertyGreetingService();
	}
	
	@Bean
	SetterGreetingService setterGreetingService() {
		return new SetterGreetingService();
	}
}
