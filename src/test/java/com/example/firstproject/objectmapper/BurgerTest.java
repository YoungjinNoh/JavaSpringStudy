package com.example.firstproject.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {
    @Test
    public void convert_to_json_from_object() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        List<String> ingredients= Arrays.asList("tomato","break","patty","sauce");
        Burger burger=new Burger("chicken burger",5000,ingredients);
        String json=objectMapper.writeValueAsString(burger);

        String expected="{\"name\":\"chicken burger\",\"price\":5000,\"ingredients\":[\"tomato\",\"break\",\"patty\",\"sauce\"]}";

        assertEquals(expected,json);
        JsonNode jsonNode=objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    public void convert_to_object_from_json() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();

        ObjectNode objectNode=objectMapper.createObjectNode();
        objectNode.put("name","chicken burger");
        objectNode.put("price",5000);
        ArrayNode arrayNode=objectMapper.createArrayNode();
        arrayNode.add("tomato");
        arrayNode.add("break");
        arrayNode.add("patty");
        arrayNode.add("sauce");
        objectNode.set("ingredients",arrayNode);
        String json=objectNode.toString();
        //String json="{\"name\":\"chicken burger\",\"price\":5000,\"ingredients\":[\"tomato\",\"break\",\"patty\",\"sauce\"]}";

        Burger burger=objectMapper.readValue(json,Burger.class);

        List<String> ingredients= Arrays.asList("tomato","break","patty","sauce");
        Burger expected=new Burger("chicken burger",5000,ingredients);

        assertEquals(expected.toString(),burger.toString());
        JsonNode jsonNode=objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
        System.out.println(burger.toString());
    }
}