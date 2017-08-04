import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ShapeService;

public class main {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class); // druhym parametrom v get bean je nazov classy cize vrati objekt danej triedy a nebudem musiet robit cast (ShapeService) pred volanim metody
       // shapeService.getCircle().setAndReturn("Koshik");
        shapeService.getCircle().setName("kak");


    }
}
