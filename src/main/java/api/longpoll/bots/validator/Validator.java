package api.longpoll.bots.validator;

/**
 * Validates an object.
 */
@FunctionalInterface
public interface Validator<T> {
    /**
     * Checks whether an object is valid
     *
     * @param obj object to be validated.
     * @return <b>true</b> if object is valid, and <b>false</b> otherwise.
     */
    boolean isValid(T obj);
}
