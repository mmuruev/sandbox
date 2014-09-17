package com.company.app;

import com.company.app.com.company.app.hello.MessagePrinter;
import com.company.app.com.company.app.hello.MessageService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

/*        ApplicationContext context =
                new AnnotationConfigApplicationContext(App.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

        List<String> testColl  = new ArrayList<>();
        testColl.add("Test");
        testColl.parallelStream().collect(Collectors.toSet());
        String[] array = testColl.toArray(new String[testColl.size()]);*/
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM hh:mm a").withZone(DateTimeZone.forID("Africa/Kampala"));
        String str = fmt.print(dt);
        System.out.println("Time: " + str);


/*        Object lock = new Object ();
        MyThread mt1 = new MyThread (lock);
        mt1.setName ("A");
        MyThread mt2 = new MyThread (lock);
        mt2.setName ("B");
        MyThread mt3 = new MyThread (lock);
        mt3.setName ("C");
        mt1.start ();
        mt2.start ();
        mt3.start ();
        System.out.println ("main thread sleeping");
        try
        {
           Thread.sleep (3000);
        }
        catch (InterruptedException e)
        {
        }
        System.out.println ("main thread awake");
        synchronized (lock)
        {
           lock.notify ();
        }*/


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

// SynchronizationDemo2.java
class SynchronizationDemo2
{
/*   public static void main (String [] args)
   {
      FinTrans ft = new FinTrans ();
      TransThread tt1 = new TransThread (ft, "Deposit Thread");
      TransThread tt2 = new TransThread (ft, "Withdrawal Thread");
      tt1.start ();
      tt2.start ();
   }*/
}
class FinTrans
{
   private String transName;
   private double amount;
  /* synchronized */void update (String transName, double amount)
   {
      this.transName = transName;
      this.amount = amount;
      System.out.println (this.transName + " " + this.amount);
   }
}
class MyThread extends Thread
{
   private Object o;
   MyThread (Object o)
   {
      this.o = o;
   }
   public void run ()
   {
      synchronized (o)
      {
         try
         {
             System.out.println (getName () + " before wait");
             o.wait ();
             System.out.println (getName () + " after wait");
         }
         catch (InterruptedException e)
         {
         }
      }
   }
}

