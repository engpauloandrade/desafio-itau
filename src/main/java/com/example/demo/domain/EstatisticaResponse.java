package com.example.demo.domain;

import java.math.BigDecimal;

public class EstatisticaResponse {
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private int count;

    public EstatisticaResponse(BigDecimal sum, BigDecimal avg, BigDecimal max, BigDecimal min, int count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public BigDecimal getSum() { return sum; }
    public BigDecimal getAvg() { return avg; }
    public BigDecimal getMax() { return max; }
    public BigDecimal getMin() { return min; }
    public int getCount() { return count; }
}
