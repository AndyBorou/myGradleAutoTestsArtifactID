package com.software.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.software.model.User;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;

@Slf4j
public final class JsonUtils {

    private JsonUtils() {
        throw new UnsupportedOperationException("Illegal access");
    }

    public static <T> T jsonToEntity(final String dataSource, final Class<T> entitiClass) {
        //работа с Json
        final Gson gson = new Gson();
        //String  path ="H:\\workspace\\autoTest\\myGradleAutoTestsArtifactID\\src\\test\\resources\\data,json";
        final String path = ClassLoader.getSystemResource(dataSource).getPath();

        try (final FileReader r = new FileReader(path)) {
            JsonReader reader = new JsonReader(r);
            return gson.fromJson(reader, entitiClass);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to read {}", dataSource);
            throw new IllegalArgumentException("ERROR");
        }
    }

}
