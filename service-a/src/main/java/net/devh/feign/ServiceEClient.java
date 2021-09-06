package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "service-e",url = "http://spring-gateway/SERVICE-E")
public interface ServiceEClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String printServiceE();
}

