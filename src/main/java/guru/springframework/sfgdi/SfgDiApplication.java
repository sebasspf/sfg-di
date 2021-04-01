package guru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.config.SebaConfig;
import guru.springframework.sfgdi.config.SfgConfig;
import guru.springframework.sfgdi.config.SfgConstructorConfig;
import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PetController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;

//@ComponentScan(basePackages = {"guru.springframework.sfgdi", "com.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
		
		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.getSound());
		
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("---- Internationalization");
		System.out.println(i18nController.sayHello());
		
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("----- Primary Bean");
		System.out.println(myController.sayHello());
		
		System.out.println("----- Property");
		
		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		
		System.out.println("----- Setter");
		
		SetterInjectedController setterInjectedController = 
				(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		
		System.out.println("----- Constructor");
		
		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
		
		System.out.println("----- Bean Scopes");
		
		SingletonBean singletonBean1 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean2.getMyScope());
		
		PrototypeBean prototypeBean1 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(prototypeBean2.getMyScope());
		
		System.out.println("------- Fake DataSource");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());
		
		System.out.println("------- Config Props Bean");
		SfgConfig sfgConfig = ctx.getBean(SfgConfig.class);
		System.out.println(sfgConfig.getUsername());
		System.out.println(sfgConfig.getPassword());
		System.out.println(sfgConfig.getJdbcurl());
		
		System.out.println("------- Constructor Binding");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcurl());
		
		System.out.println("------- Seba Config");
		SebaConfig sebaConfig = (SebaConfig) ctx.getBean("sebaConfig");
		System.out.println(sebaConfig.getUsername());
		System.out.println(sebaConfig.getPassword());
		System.out.println(sebaConfig.getJdbcurl());
	}

}
