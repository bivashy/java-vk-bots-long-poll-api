package api.longpoll.bots.converter.impl;

import api.longpoll.bots.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class ListConverter implements Converter<List<?>, String> {
    @Override
    public String convert(List<?> list) {
        return list.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
