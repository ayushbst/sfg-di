package DependencyInjection.di;

import DependencyInjection.di.Controllers.ConstructorInjectedController;
import DependencyInjection.di.Controllers.MyController;
import DependencyInjection.di.Controllers.PropertyInjectedController;
import DependencyInjection.di.Controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"DependencyInjection/di/Controllers"})
public class DiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String ans=myController.sayHello();
		System.out.println(ans);


		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController") ;
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println("----------Property injection ------------");
		System.out.println(propertyInjectedController.getGreeting());
		System.out.println("----------Constructor injection ------------");
		System.out.println(constructorInjectedController.getGreeting());
		System.out.println("----------Setter injection ------------");
		System.out.println(setterInjectedController.getGreeting());
	}

}
