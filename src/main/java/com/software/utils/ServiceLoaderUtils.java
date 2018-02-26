package com.software.utils;

import io.vavr.control.Try;
import one.util.streamex.StreamEx;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;


public class ServiceLoaderUtils {

    private ServiceLoaderUtils(){
        throw new UnsupportedOperationException("error");
    }

  //  ClassLoader анализирует все загруженные в класс пас файлы (DataReader)
    public static <T> List<T> load(final Class<T> type, final ClassLoader classLoader){
        //вовращает все имплементации инрфейса  Class<T> type
        // находи в classLoader inteface Class<T> type
        return Try.of(() -> StreamEx.of(ServiceLoader.load(type, classLoader).iterator()).toList())
                .getOrElseGet(ex -> Collections.emptyList());
    }

}
