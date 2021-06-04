package net.devh;

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
public class ServiceC1Controller {

    @Autowired
    private Registration registration;

    @Value("${msg:unknown}")
    private String msg;

    @RequestMapping(value = "/cccccccccccc", method = RequestMethod.GET)
    public String printServiceC() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===cccccccccccc>Say " + msg + "\n";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printServiceCroot() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" +
                registration.getPort() + ")" + "===>Say " + msg + "\n";
    }
}
