package com.example.response;

import com.example.response.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResponseApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("---- Object Mapper -----");
        // 1. 오브젝트 매퍼를 사용하려면 게터 세터가 있어야 함 (겟 메소드를 활용함)
        // 2. 디폴트 생성자도 반드시 있어야 함
        // 3. 없는 프로퍼티에 대해 'get~~' 이라는 식으로 이름을 지으면 고장남

        // @RestController 로 JSON 을 주고받으면 ObjectMapper 를 활용하여 알아서 파싱함

        // Test JSON -> Object
        // Object -> Test JSON

        // controller req json(text) -> object
        // response object -> json text

        var objectMapper = new ObjectMapper();

        // object -> test
        User user = new User();
        user.setName("엄준식");
        user.setAddress("한라");
        user.setPhoneNumber("123");
        user.setAge(25);

        String stringify = objectMapper.writeValueAsString(user);
        // @JsonProperty 를 사용했으므로 phoneNumber 는 phone_number 로 출력됨
        System.out.println(stringify);

        // text -> Object
        var objectUser = objectMapper.readValue(stringify, User.class);
        System.out.println(objectUser);

    }

}
