package vaakom.mockito.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import vaakom.mockito.core.utils.NumUtils;
import vaakom.mockito.core.service.NumberServiceImpl;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BasicMockingTest {

    @Mock
    private NumUtils numberUtil;

    @InjectMocks
    private NumberServiceImpl service;

    @Test
    public void getSum() {
        when(numberUtil.getNumbers()).thenReturn(new int[] {1, 2, 3});

        Assert.assertEquals(6, service.getSum());
    }

    @Test
    public void getSummEmpty() {
        when(numberUtil.getNumbers()).thenReturn(new int[] {});

        Assert.assertEquals(0, service.getSum());
    }
}