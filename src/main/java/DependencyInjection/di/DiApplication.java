package DependencyInjection.di;

import DependencyInjection.di.Controllers.MyController;
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

	}

}
