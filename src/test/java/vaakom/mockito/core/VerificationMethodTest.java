package vaakom.mockito.core;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class VerificationMethodTest {

    private List<String> list = mock(List.class);

    @Test
    public void verifyMethodCalledTest(){
        list.get(0);
        list.get(1);

        verify(list).get(0);

        verify(list, times(2)).get(anyInt());

        verify(list, atLeast(1)).get(anyInt());

        verify(list, never()).get(123);
    }

    @Test
    public void argumentCapturingTest(){
        list.add("Some value");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(list).add(captor.capture());

        assertEquals("Some value", captor.getValue());
    }

    @Test
    public void multiplyArgumentCapturingTest(){
        list.add("Some value 1");
        list.add("Some value 2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(list, times(2)).add(captor.capture());

        assertEquals("Some value 1", captor.getAllValues().get(0));
        assertEquals("Some value 2", captor.getAllValues().get(1));
    }

}
