package felipe.bc.limitsservice.dto;

import java.io.Serializable;

public class LimitsConfig implements Serializable {

    private static final long serialVersionUID = -2794010746519484418L;

    private int min;
    private int max;

    public LimitsConfig() {
    }

    public LimitsConfig(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
