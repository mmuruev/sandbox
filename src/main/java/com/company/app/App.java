package com.company.app;

import com.company.app.com.company.app.hello.MessagePrinter;
import com.company.app.com.company.app.hello.MessageService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Test app
 */
@Configuration
@ComponentScan
public class App {

//    private String test = "Checker";

//    protected Class entityClass;

//    private Object container;
//    private Object classVar;

//    public App() {
//        //ParameterizedType genericSuperclass =
//        class DummyT extends App<T> {
//        }
//
//        container = getClass().getGenericSuperclass();
//        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
//        // this.entityClass =
//        classVar = genericSuperclass.getActualTypeArguments()[0];
//    }

    @Bean
    MessageService mockMessageService() {
        return () -> {
            System.out.print("Anonimous");
            return "Hello World!";
        };
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(App.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

//        List<String> testColl  = new ArrayList<>();
//        testColl.parallelStream().collect(Collectors.toSet());
//
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Scanner a waiting");
        System.out.println(scanner.nextInt());*/


/*        App<Integer> me = new App<>();
        System.out.println("Me: " + me);
        new App<Integer>().printTypeParam();*/
    }

    @Override
    public String toString() {
        return toString(this);
    }

    public String toString(Object $object) {
        /*
         * Generate toString including transient and static attributes.
         */
        return ReflectionToStringBuilder.toString($object,
                ToStringStyle.MULTI_LINE_STYLE, true, true);
    }

/*    public void printTypeParam() {
        class DummyT extends App<T> {
        }
        class DummyString extends App<String> {
        }

        ParameterizedType ptT =
                ((ParameterizedType) DummyT.class.getGenericSuperclass());

        ParameterizedType ptString =
                ((ParameterizedType) DummyString.class.getGenericSuperclass());

        System.out.println("MeT: " + entityClass);
        System.out.println("DummyT: " + ptT + " " + ptT.getActualTypeArguments()[0]);
        System.out.println("DummyString: " + ptString + " " + ptString.getActualTypeArguments()[0]);

    }*/
}

