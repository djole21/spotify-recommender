package dev.djmitrovic.spotifyrecommender.utils;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectToQueryParamsConverter {

    public static String convertToQueryParams(Object object) throws IllegalAccessException {
        Map<String, String> queryParams = new LinkedHashMap<>();

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value != null) {
                queryParams.put(field.getName(), URLEncoder.encode(value.toString(), StandardCharsets.UTF_8));
            }
        }

        StringBuilder queryString = new StringBuilder();
        queryParams.forEach((key, value) -> {
            if (!queryString.isEmpty()) {
                queryString.append("&");
            }
            queryString.append(key).append("=").append(value);
        });

        return queryString.toString();

    }
}
