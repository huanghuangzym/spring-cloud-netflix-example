package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "service-c")
public interface ServiceCClient {

    @RequestMapping(value = "/cccccccccccc", method = RequestMethod.GET)
    String printServiceC();
}

