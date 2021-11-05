package api.longpoll.bots.converter.impl;

import api.longpoll.bots.converter.Converter;

public class BoolIntConverter implements Converter<Boolean, Integer> {
    @Override
    public Integer convert(Boolean aBoolean) {
        return aBoolean ? 1 : 0;
    }
}
