package vaakom.mockito.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleReturnsAndParametersTest {

    private List list = mock(List.class);

    @Test
    public void mockMultipleReturns(){
        when(list.size()).thenReturn(1).thenReturn(5);
        assertEquals(1, list.size());
        assertEquals(5, list.size());
    }

    @Test
    public void mockWithParameterTest(){
        when(list.get(10)).thenReturn("Hey, i'm number 10!");
        assertEquals("Hey, i'm number 10!", list.get(10));
    }

    @Test
    public void mockWithGenericParameterTest(){
        when(list.get(anyInt())).thenReturn("Hey, i'm here!");
        assertEquals("Hey, i'm here!", list.get(101));
        assertEquals("Hey, i'm here!", list.get(0));
    }
}
