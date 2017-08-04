package aspects;

import model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect                                         //vykonat pre vsetky metody ktore maju akekolvek arguemny a aj bez arguemntov @Before("execution(* *(..))")  prazdne zatvorky znamenaju ziadne argumenty a hviezdicka znamena pre jednu alebo viac argumentov
public class LoggingAspect {                    //vykonat pre vsetky gettery ktore vracaju cokolvek @Before("execution(public * get*())")
                                                //vykonat metodu pre vsetky gettery v projekte ktore vracaju string @Before("execution(public String get*())")
    @Before("allCircleMethods()")//pred tym ako sa vykona public String getName() tak sa vykona tato metoda z akejkolvek classy ak chcem presne definovat pre ktoru classu a metodu chcem volat tuto metodu treba napisat celu cestu k triede a nazov metody
    public void LoggingAdvice() {
        System.out.println("Advice log started");
    }


    @Pointcut("execution(* get*(..))")    // @Pointcut nahradzuje expresion v before
    public void allGetters() {}             //dummy method

    @Pointcut("within(model.Circle)") //all methods in Circle class execution(* model.Circle.*(..)) alebo within(model.Circle)
    public void allCircleMethods() {}
// ak chcem zahrnut vsetky sub-packages tak pridam bodku a hviezdicku    model..*

    @Before("args(arg)")
    public void allStringArgumentMethods(String arg) {
        System.out.println("New name settet to: "+arg);
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnedString")   //vykona sa ak sa vykona metoda ktora ma vstupny parameter string a ulozi Stringovu vratenu hodnotu do premennej returnedString
    public void stringArgumentMethods(String name, String returnedString){
        System.out.println("returned "+returnedString);
    }

    @Around("allCircleMethods()")
    public void myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){

        try {
            System.out.println("before advice");
            proceedingJoinPoint.proceed();        //vykona metodu
            System.out.println("after returning");
        } catch (Throwable throwable) {
            System.out.println("after thorowing");
        }
        System.out.println("after finally");
    }


    /*
    ak chcem pouzit around na metodu ktora nieco vracia

        @Around("allGetters()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try {
            System.out.println("before advice");
            returnValue = proceedingJoinPoint.proceed();        //vykona metodu a ulozi navratovu hodnotu do premennej returnValue
            System.out.println("after returning");
        } catch (Throwable throwable) {
            System.out.println("after thorowing");
        }
        System.out.println("after finally");
    return returnValue;
    }

     */





}//anotacie @Before, @After
//AfterReturning -vykona sa ked vrati hodnotu bez vuhodenia exceptionu
//AfterThrowing - vykona sa ked vyhodi exception
// @AfterThrowing(pointcut="args(name), throwing="ex")
//public void afterThrowingException(String name, Exception ex){...}

/*



@Aspect                                         //vykonat pre vsetky metody ktore maju akekolvek arguemny a aj bez arguemntov @Before("execution(* *(..))")  prazdne zatvorky znamenaju ziadne argumenty a hviezdicka znamena pre jednu alebo viac argumentov
public class LoggingAspect {                    //vykonat pre vsetky gettery ktore vracaju cokolvek @Before("execution(public * get*())")
                                                //vykonat metodu pre vsetky gettery v projekte ktore vracaju string @Before("execution(public String get*())")
    @Before("allGetters()")       //pred tym ako sa vykona public String getName() tak sa vykona tato metoda z akejkolvek classy ak chcem presne definovat pre ktoru classu a metodu chcem volat tuto metodu treba napisat celu cestu k triede a nazov metody
    public void LoggingAdvice() {
        System.out.println("Advice run. Get Method Called.");
    }

//    @Before("allGetters()")
//    public void LoggingAdvice2(JoinPoint joinPoint){
//        String circleName = ((Circle) joinPoint.getTarget()).name();// predym ako pouzijem getter zoberiem dany object ...
//        System.out.println("This is called before getter and name of circle is: "+circleName);
//    }


    @Pointcut("execution(* get*())")    // @Pointcut nahradzuje expresion v before
    public void allGetters() {}             //dummy method

    @Pointcut("within(model.Circle)") //all methods in Circle class execution(* model.Circle.*(..)) alebo within(model.Circle)
    public void allCircleMethods() {}
// ak chcem zahrnut vsetky sub-packages tak pridam bodku a hviezdicku    model..*


    @Pointcut("args(String)")                   //vsetky metody ktore maju v argumente string
    public void allStringArgumentMethods() {
        System.out.println("New name setted");
    }
                            //tento argument string mozem definovat aj v metode
    @Pointcut("args(name)")
    public void allStringArgumentMethods(String name) {
        System.out.println("New name settet to: "+name);
    }
}

 */