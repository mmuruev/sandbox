package com.company.app;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.ParameterizedType;

/**
 * Test app
 */
public class App<T> extends Parent<T>{

    private String test = "Checker";

    protected Class entityClass;

    private Object container;
    private Object classVar;

    public App() {
        //ParameterizedType genericSuperclass =
        class DummyT extends App<T> {
        }

         container =  getClass().getGenericSuperclass();
         ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        // this.entityClass =
         classVar =        genericSuperclass.getActualTypeArguments()[0];
    }

    public static void main(String[] args) {
        App<Integer> me = new App<>();
        System.out.println("Me: " + me);
        new App<Integer>().printTypeParam();
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

    public void printTypeParam() {
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

    }
}
