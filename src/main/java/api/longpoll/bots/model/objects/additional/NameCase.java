package api.longpoll.bots.model.objects.additional;

/**
 * Case for declension of user name and surname.
 */
public enum NameCase {
    /**
     * Nominative.
     */
    NOMINATIVE("nom"),

    /**
     * Genitive.
     */
    GENITIVE("gen"),

    /**
     * Dative.
     */
    DATIVE("dat"),

    /**
     * Accusative.
     */
    ACCUSATIVE("acc"),

    /**
     * Instrumental.
     */
    INSTRUMENTAL("ins"),

    /**
     * Prepositional.
     */
    PREPOSITIONAL("abl");

    /**
     * Param value.
     */
    private final String value;

    NameCase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
