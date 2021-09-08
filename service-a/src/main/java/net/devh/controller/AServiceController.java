package net.devh.controller;

import net.devh.feign.ServiceBClient;
import net.devh.feign.ServiceCClient;
import net.devh.feign.ServiceEClient;
import net.devh.feign.BaiduClient;
//import net.devh.ribbon.RBServiceBClient;
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


@RefreshScope
@RestController
@Api
public class AServiceController {

    @Value("${name:unknown}")
    private String name;

    @Autowired
    private HystrixWrappedServiceBClient hfServiceBClient;

    @Autowired
    private ServiceBClient serviceBClient;

    //@Autowired
    //private RBServiceBClient rbserviceBClient;

    @Autowired
    private ServiceCClient serviceCClient;

    @Autowired
    private ServiceEClient serviceEClient;

    @Autowired
    private BaiduClient bdClient;


    @Autowired
    private Registration registration;

    @RequestMapping(value = "/fe", method = RequestMethod.GET)
    public String printServiceFE() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceEClient.printServiceE();
    }


    @RequestMapping(value = "/fb", method = RequestMethod.GET)
    public String printServiceFB() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceBClient.printServiceB();
    }


    @RequestMapping(value = "/fc", method = RequestMethod.GET)
    public String printServiceAC() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceCClient.printServiceC();
    }


    @RequestMapping(value = "/baidu", method = RequestMethod.GET)
    public String printBaidu() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                bdClient.printBaidu();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printServiceA() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
        registration.getPort() + ")" + "===>name:" + name+ "\n";
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String printping() {
        return "get ping";
    }

}
