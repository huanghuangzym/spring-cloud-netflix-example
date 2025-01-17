package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "baidu",url = "http://www.baidu.com")
public interface BaiduClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String printBaidu();
}
