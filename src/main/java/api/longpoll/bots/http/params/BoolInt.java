package api.longpoll.bots.http.params;

/**
 * Boolean value represented by 1 and 0.
 */
public class BoolInt {
    /**
     * Original boolean value.
     */
    private boolean booleanValue;

    /**
     * Integer value:
     * <ul>
     *     <li>1 if {@link BoolInt#booleanValue} is <b>true</b>.</li>
     *     <li>0 if {@link BoolInt#booleanValue} is <b>false</b>.</li>
     * </ul>
     */
    private int intValue;

    public BoolInt(boolean booleanValue) {
        this.booleanValue = booleanValue;
        this.intValue = booleanValue ? 1 : 0;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return "BoolInt{" +
                "booleanValue=" + booleanValue +
                ", intValue=" + intValue +
                '}';
    }
}
