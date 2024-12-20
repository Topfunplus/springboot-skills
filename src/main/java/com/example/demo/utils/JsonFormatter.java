package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

// JSON 格式化工具
public class JsonFormatter {
    public static String formatter(Object needFormatObject) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String jsonString = objectMapper.writeValueAsString(needFormatObject);
            System.out.println(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            System.out.println("Json格式化失败" + e.getMessage());
            return null;
        }
    }
}
