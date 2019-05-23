package vaakom.mockito.core.service;

import vaakom.mockito.core.utils.NumUtils;

import java.util.Arrays;

public class NumberServiceImpl implements NumberService {

    private NumUtils numUtils;

    public NumberServiceImpl(NumUtils numUtils) {
        this.numUtils = numUtils;
    }

    @Override
    public int[] getNumbers() {
        return numUtils.getNumbers();
    }

    @Override
    public int getSum() {
        if(numUtils.getNumbers() == null || numUtils.getNumbers().length == 0)
            return 0;

        return Arrays.stream(numUtils.getNumbers()).sum();
    }
}
