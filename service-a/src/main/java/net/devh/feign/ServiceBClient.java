package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "service-b",url = "http://service-b.metadata.asm.com")
public interface ServiceBClient {

    @RequestMapping(value = "/bbbbbbbbbbb", method = RequestMethod.GET)
    String printServiceB();
}

