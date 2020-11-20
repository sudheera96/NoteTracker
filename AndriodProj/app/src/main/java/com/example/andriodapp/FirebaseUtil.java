package com.example.andriodapp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.Map;

public enum FirebaseUtil {
    ;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final JavaType JAVA_TYPE = OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, String.class, Object.class);

    static {
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

   

}