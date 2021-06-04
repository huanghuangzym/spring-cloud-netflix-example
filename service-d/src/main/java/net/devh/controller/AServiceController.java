package net.devh.controller;

import net.devh.feign.ServiceBClient;
import net.devh.feign.ServiceCClient;
import net.devh.feign.ServiceAClient;
import net.devh.feign.ServiceEClient;
import net.devh.feign.BaiduClient;
import net.devh.hystrix.HystrixWrappedServiceBClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 2016/6/3
 */
@RefreshScope
@RestController
@Api
public class AServiceController {

    @Value("${name:unknown}")
    private String name;

    @Autowired
    private ServiceAClient serviceAClient;

    @Autowired
    private ServiceEClient serviceEClient;

    @Autowired
    //private HystrixWrappedServiceBClient serviceBClient;
    private ServiceBClient serviceBClient;

    @Autowired
    //private HystrixWrappedServiceBClient serviceBClient;
    private ServiceCClient serviceCClient;

    @Autowired
    private BaiduClient bdClient;


    @Autowired
    private Registration registration;

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public String printServiceA() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceAClient.printServiceA();
    }

    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public String printServiceB() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceBClient.printServiceB();
    }


    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public String printServiceC() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceCClient.printServiceC();
    }

    @RequestMapping(value = "/e", method = RequestMethod.GET)
    public String printServiceE() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceEClient.printServiceE();
    }


    @RequestMapping(value = "/baidu", method = RequestMethod.GET)
    public String printBaidu() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                bdClient.printBaidu();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printroot() {
        return "get root \n";
    }


    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String printping() {
        return "get ping \n";
    }

}
