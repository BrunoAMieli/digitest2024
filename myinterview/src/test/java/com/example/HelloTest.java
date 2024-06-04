package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HelloTest {

    @Test
    public void testSayHelloWithClient() {
        String mockApiResponse = "Hello from API!";
        RESTAPIClientTask apiClientMock = Mockito.mock(RESTAPIClientTask.class);
        when(apiClientMock.getResponse()).thenReturn(mockApiResponse);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Hello hello = new Hello(apiClientMock);
        hello.sayHello();

        System.setOut(System.out);

        assertEquals("Hello from API!", outputStream.toString().trim());
    }

    @Test
    public void testSayHelloWithServer() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Hello hello = new Hello();
        hello.sayHello();

        System.setOut(System.out);

        assertEquals("Olá, mundo!", outputStream.toString().trim());
    }
}
