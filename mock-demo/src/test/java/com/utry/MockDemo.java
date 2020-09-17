package com.utry;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/9/11
 * Time: 10:58 下午
 * Description: 
*/
public class MockDemo {

    @Test
    public void test1(){
        List mocklist = mock(List.class);

        mocklist.add("One");

        mocklist.clear();

        verify(mocklist).add("One");

        verify(mocklist).clear();
    }

    @Test
    public void test2(){
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");

        when(mockedList.get(1)).thenReturn(new RuntimeException());

        System.out.println(mockedList.get(0));

        System.out.println(mockedList.get(1));

        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    @Test
    public void test3(){
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
//        when(mockedList.contains(argThat(isValid()))).thenReturn(true);

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
//        verify(mockedList).add(argThat(someString -> someString.length() > 5));
    }


    @Test
    public void testSafe(){
//        Class callerClass = Reflection.getCallerClass();
//        if(callerClass.getClassLoader() != null){
//            throw new SecurityException("unsafe");
//        }
//        return theUnsafe
    }
}
