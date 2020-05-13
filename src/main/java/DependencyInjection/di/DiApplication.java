package DependencyInjection.di;

import DependencyInjection.di.Controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"DependencyInjection/di/Controllers","DependencyInjection/di/services"})
public class DiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String ans=myController.sayHello();
		System.out.println(ans);


		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController") ;
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		PrimaryController primaryController = (PrimaryController) ctx.getBean("primaryController");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println("----------Property injection ------------");
		System.out.println(propertyInjectedController.getGreeting());
		System.out.println("----------Constructor injection ------------");
		System.out.println(constructorInjectedController.getGreeting());
		System.out.println("----------Setter injection ------------");
		System.out.println(setterInjectedController.getGreeting());
		System.out.println("----------Primary injection ------------");
		System.out.println(primaryController.getGreeting());

		//Change Profile in resource->Application.properties to ES or EN
		System.out.println("----------i18n Controller ------------");
		System.out.println(i18nController.sayHello());
	}

}
