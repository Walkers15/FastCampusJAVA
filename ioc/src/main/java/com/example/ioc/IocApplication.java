package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "https://www.dnd.ac/projects/9th?teams=10&part=backend";

        Encoder encoder = context.getBean("base64Encoder", Encoder.class);
        System.out.println(encoder.encode(url));

        encoder.setIEncoder(context.getBean(UrlEncoder.class));
        System.out.println(encoder.encode(url));
    }

}

@Configuration // 여러 Bean 동시 등록
class AppConfig {
    @Bean("base64Encoder")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return  new Encoder(base64Encoder);
    }

    @Bean("urlEncoder2")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}