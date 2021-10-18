package net.devh.controller;

import net.devh.feign.ServiceAClient;
import net.devh.feign.ServiceBClient;
import net.devh.feign.ServiceCClient;
import net.devh.feign.ServiceDClient;
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
    private ServiceAClient serviceAClient;

    @Autowired
    private ServiceBClient serviceBClient;

    //@Autowired
    //private RBServiceBClient rbserviceBClient;

    @Autowired
    private ServiceCClient serviceCClient;

    @Autowired
    private ServiceDClient serviceDClient;

    @Autowired
    private BaiduClient bdClient;


    @Autowired
    private Registration registration;

    @RequestMapping(value = "/hfb", method = RequestMethod.GET)
    public String printServiceHFB() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                hfServiceBClient.printServiceB();
    }

    @RequestMapping(value = "/fa", method = RequestMethod.GET)
    public String printServiceFA() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceAClient.printServiceA();
    }

    @RequestMapping(value = "/fb", method = RequestMethod.GET)
    public String printServiceFB() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceBClient.printServiceB();
    }


    @RequestMapping(value = "/fc", method = RequestMethod.GET)
    public String printServiceFC() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceCClient.printServiceC();
    }

    @RequestMapping(value = "/fd", method = RequestMethod.GET)
    public String printServiceFD() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>name:" + name + "<br/>" + 
                serviceDClient.printServiceD();
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

    @RequestMapping(value = "/eeeeeee", method = RequestMethod.GET)
    public String printServiceEEEEEEE() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
        registration.getPort() + ")" + "===>name:" + name+ "\n";
    }


    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String printping() {
        return "get ping";
    }

}
