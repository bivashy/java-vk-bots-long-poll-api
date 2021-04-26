package api.longpoll.bots.validators;

@FunctionalInterface
public interface Validator<T> {
    boolean isValid(T t);
}
