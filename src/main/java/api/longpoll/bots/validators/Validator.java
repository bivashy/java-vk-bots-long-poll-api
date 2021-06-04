package api.longpoll.bots.validators;

/**
 * Generic Validator
 *
 * @param <T> type of object to be validated.
 */
@FunctionalInterface
public interface Validator<T> {
    /**
     * Checks whether object is valid
     *
     * @param t object to be checked.
     * @return <b>true</b> if object is valid, and <b>false</b> otherwise.
     */
    boolean isValid(T t);
}
