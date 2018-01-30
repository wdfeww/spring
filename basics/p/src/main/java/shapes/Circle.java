package shapes;

import main.DrawEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/*
ANOTACIE PRE TRIEDU
COMPONENT
@Component
@Component("beanID") definuje pre component bean id
je anotacia ktora sa dava pred class a definuje triedu ze bude spring bean
ak ma tuto anotaciu tak sa tato trieda moze definovat len raz cize moze exitovat len jeden bean typu (class) Circle
a kedze point mam definovany viac krat prto tuto anotaciu nemozem pouzit pre point triedu
kedze som pouzil tuto anotaciu nebudem musiet v spring.xml vytvarat bean cyrcle  <bean id="circle" class="shapes.Circle"/> ale
poviem springu nech oskenuje vsetky classy a hlada anotaciu component v balicku shape <context:component-scan base-package="shapes"/>
cize oskenuje triedu circle najde anotaciu a automaticky vytvori bean
@Service
V standardoch sa pouziva namiesto @Component anotacia @Service funguje rovnako ako component
ak mam service anotaciu tak pridavam triede additional information ze sa jedna o service bean
@Repository- definuje ze sa jedna o data objeckt
@Controller
 */

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point center;
    private ApplicationEventPublisher applicationEventPublisher;


    @Autowired
    private MessageSource messageSource;

    public Point getCenter() {
        return center;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    /*

    REQURED processor
    ak chcem aby spring vedel ze metoda setCenter cize ak chcem aby bola inicializacia objektu center povinna tak pouzijem anotaciu @Required pred setter
    je potrebne do spring.xml pridat bean <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
    vysledkom je ze java nevyhodi null exception ale exception vyhodi spring
   */

    /*
    AUTOWIRED processor
    @Autowired
    nastavujem ak chcem aby sa premenna v objekte automaticky nastavila
    je potrebny bean <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
    ak bude v spring.xml len jeden bean typu point a circle bude mat nastavenu anotaciu autowired tak mu priradi bean poinu ktory tam je
    ak bude viac beanov typu point tak spring nebude vediet ktory point bean priradit(inject) circlu pretoze sa snazi priradit mu ojbect alebo premennu podla typu
    nasledne spring overi ci sa niektory z beanov nevola rovnako ako premenna v triede ak ano priradi (injectne) ho
    dalsou anotaciou je Qualifier v ktorom nastavime meno Qualifiera napr na circleRelated a v spring.xml nastavim pre jednotlive beany <
     */

    /*
    RESOURCE
    @Resource
    ak chcem pridelit presny nazov id v spring.xml premennej v tejto triede tak mozem pouzit Resource kde nastavim hodnotu name na rovnaku hodnotu aku ma id dany point
    @Resource(name="pointC")
    ak pouzijem anotaciu bez specifikacie mena
    @Resource
    tak bude spring hladat nazov podla nazvu premennej v triede cize center

     */
    @Resource(name="pointC")
    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {

        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default drawing", null));
        System.out.println(this.messageSource.getMessage("drawing.circle.points", new Object[] {center.getX(), center.getY()}, "Default circle point show", null));
       // System.out.println(this.messageSource.getMessage("greeting", null, "Default message", null));
        DrawEvent drawEvent = new DrawEvent(this);
        applicationEventPublisher.publishEvent(drawEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /*ANOTACIE PRE METODY
    anotacia pre methodu ktora sa ma spustit pri inicializacii objektu
    @PostConstruct

    anotacia pre metodu ktora sa ma spustit pri destroy
    @PreDestroy
    je potrebne mat vytvorit AbstractApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
                             context.registerShutdownHook();
    nestaci obycajny ApplicationContext lebo nikdy sa nespravi destroy
     */
}
