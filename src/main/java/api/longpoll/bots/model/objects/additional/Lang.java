package api.longpoll.bots.model.objects.additional;

/**
 * Lang.
 */
public enum Lang {
    RU(0),
    UK(1),
    BE(2),
    EN(3),
    ES(4),
    FI(5),
    DE(6),
    IT(7);

    /**
     * Lang code.
     */
    private final int code;

    Lang(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
