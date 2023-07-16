package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dto.Car;
import org.example.dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가1234");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("XC60");
        car2.setCarNumber("11가1235");
        car2.setType("SUV");

        user.setCars(Arrays.asList(car1, car2));

        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").toString();
        int _age = jsonNode.get("age").asInt();
        System.out.println(_name + " " + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<>(){});
        System.out.println(_cars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "김길동");
        System.out.println(objectNode.toPrettyString());
        String __name = objectNode.get("name").toString();
        System.out.println(__name);
    }
}