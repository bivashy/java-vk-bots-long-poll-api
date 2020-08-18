package api.longpoll.bots.methods;

import org.jsoup.Connection;

public abstract class DefaultGetMethod<Response> extends Method<Response> {
    @Override
    protected Connection.Method getMethod() {
        return Connection.Method.GET;
    }
}
