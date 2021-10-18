package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "service-e")
public interface ServiceEClient {

    @RequestMapping(value = "/eeeeeee", method = RequestMethod.GET)
    String printServiceE();
}

