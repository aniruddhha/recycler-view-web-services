package com.melayer.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;

/**
 * Created by root on 9/3/15.
 */
public class JsonMan {

    public static <T>  T toObject(String json,Class<T> cls) throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        T t = mapper.readValue(json, cls);
        mapper = null;

        return t ;
    }

    public static <T> String fromObject(T obj) throws Exception{

        ObjectMapper mapper = new ObjectMapper();

        String data = mapper.writeValueAsString(obj);
        mapper = null;

        return data;
    }
}
