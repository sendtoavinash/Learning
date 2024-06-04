package com.avi;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

    public static void main(String[] args) throws JsonProcessingException {

        String x = """
                {"tranReceived":"N",
                "tranDate":"0001-01-01T00:00:00",
                "status":"99",
                "errorMsg":"TRAN DETAILS NOT AVAILABLE"}
                """;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(x);
        String dataValue = jsonNode.get("errorMsg").asText();
        System.out.println(dataValue);

    }
}
