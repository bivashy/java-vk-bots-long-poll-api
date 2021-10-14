package api.longpoll.bots.http.params;

/**
 * Boolean value represented by 1 and 0.
 */
public class BoolInt {
    /**
     * Original boolean value.
     */
    private final boolean booleanValue;

    public BoolInt(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public int getIntValue() {
        return booleanValue ? 1 : 0;
    }

    @Override
    public String toString() {
        return "BoolInt{" +
                "booleanValue=" + booleanValue +
                '}';
    }
}
