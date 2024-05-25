package br.feira.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtil {
    public static <T, R> List<R> mapList(List<T> source, Function<T, R> mapper) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }
}
