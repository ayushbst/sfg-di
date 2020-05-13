package DependencyInjection.di.Controllers;

import DependencyInjection.di.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    public PropertyInjectedController propertyInjectedController;
    @BeforeEach
    void setUp() {
        propertyInjectedController=new PropertyInjectedController();
        propertyInjectedController.greetingService = new ConstructorGreetingService();
    }

    @Test
    void getGreeting()
    {
        System.out.println(propertyInjectedController.getGreeting());
    }
}