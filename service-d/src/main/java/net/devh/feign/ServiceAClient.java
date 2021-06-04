package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "service-a")
public interface ServiceAClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String printServiceA();
}

