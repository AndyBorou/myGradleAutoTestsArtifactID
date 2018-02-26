package com.software.dataWork;

import com.software.model.User;
import com.software.utils.JsonUtils;
import io.vavr.control.Try;

import javax.xml.bind.JAXBContext;
import java.lang.reflect.Array;

import static java.lang.ClassLoader.getSystemResource;
import static java.util.Optional.ofNullable;
import static javax.xml.bind.JAXBContext.newInstance;

public class XmlReader implements DataReader {

    @Override
    public String getDataType() {
        return "xml";
    }

    @SuppressWarnings("unchecked")
    public <T> T readForm(String dataSource, Class<T> entityClass) {

        return Try.of(() -> newInstance(entityClass))
                .mapTry(JAXBContext::createUnmarshaller)
                .mapTry(unmarshaller -> (T) unmarshaller.unmarshal(getSystemResource(dataSource)))
                .getOrElseThrow( e -> new IllegalArgumentException(e));
    }
}
