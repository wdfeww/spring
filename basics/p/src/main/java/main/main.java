package main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.Shape;
import shapes.Triangle;

public class main {
    public static void main(String [] args){
//        Triangle triangle = new Triangle();

//        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));  spring.xml musi byt v priecinku kde je projekt
//        Triangle triangle = (Triangle) factory.getBean("triangle");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");//spring.xml do priecinku resourses
//        Shape shape = (Shape) context.getBean("triangle");
//        Shape shape1 = (Shape) context.getBean("circle");
//        if(shape==shape1)
//            System.out.println("same");
//        else
//            System.out.println("not same");
//        shape.draw();
//        shape1.draw();
        System.out.println(context.getMessage("greeting", null, "Default message", null));

                //parameters getMessage()  name of property , parameters for this text, default value,
/*
        LIFECYCLE CALLBACKS
        //volanie metod pred initializaciou a pred znicenim beanu
        //AbstractApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //context.registerShutdownHook();
        //Triangle triangle = (Triangle) context.getBean("triangle");
        //triangle.draw();


        trieda triangle implementuje InitializingBean a overidne metodu ktora sa zavola pred inicializaciou beanu
        dalsia implementacia DisposableBean a overidne metodu ktora sa zavola pred znicenim beanu
        (objekt sa znici po vykonani metody draw)


         dalsou metodou je pridat nic neimplementovat ale pridat do beanu atributy
         <bean id="triangle" class="shapes.Triangle" init-method="methodName" destroy-method="methodName">  init method zavola metodu pred inicializaciou objektu
            </bean>                                                                                          destroy-method zavola funkciu pred znicenim objektu

        mozem vytvorit defaultne methody ktore sa budu volat pri kazdom beane
        v tagu beans pridam atribut default-init-methods a default-destroy-method

        mozem pouzit aj kombinaciu atributov v xml spolu s implementaciou
        najprv sa vykonaju implementovane overidnute metody a potom metody ktore su zapisane v atributoch xml

                 */


    }
}
