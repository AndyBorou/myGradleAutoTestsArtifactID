package com.software.dataWork;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class JsonReader implements DataReader {

    @Override
    public String getDataType() {
        return "json";
    }

    @Override
    public <T> T readForm(final String dataSource, final Class<T> entityClass) {

        //работа с Json
        final Gson gson = new Gson();
        //String  path ="H:\\workspace\\autoTest\\myGradleAutoTestsArtifactID\\src\\test\\resources\\data,json";
        final String path = ClassLoader.getSystemResource(dataSource).getPath();

        try (final FileReader r = new FileReader(path)) {
            com.google.gson.stream.JsonReader reader = new com.google.gson.stream.JsonReader(r);
            return gson.fromJson(reader, entityClass);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to read {}", dataSource);
            throw new IllegalArgumentException("ERROR");
        }
    }
}
