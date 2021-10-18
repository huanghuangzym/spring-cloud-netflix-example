package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "service-d")
public interface ServiceDClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String printServiceD();
}

