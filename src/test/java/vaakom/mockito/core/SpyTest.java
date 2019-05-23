package vaakom.mockito.core;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void getSum() {
        //Keep original behaviour
        ArrayList<String> list = spy(ArrayList.class);

        list.add("One");

        assertEquals("One", list.get(0));
        verify(list).add("One");

        //Mock one method
        when(list.size()).thenReturn(5);

        assertEquals(5, list.size() );
    }

}
