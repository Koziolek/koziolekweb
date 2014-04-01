package pl.koziolekweb.java8.defaultmethods;

import org.testng.annotations.Test;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class DefaultMethodsExample implements MyInterface {

    @Test
    public void defaultExapmle() {
        justImplemented("Hello World");
    }
}


interface MyInterface {

    default void justImplemented(String message) {
        System.out.println("message = [" + message + "] " + this);
    }
}