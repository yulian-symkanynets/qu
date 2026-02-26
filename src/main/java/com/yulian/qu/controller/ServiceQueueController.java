package com.yulian.qu.controller;


import com.yulian.qu.entity.ServiceQueue;
import com.yulian.qu.service.ServiceQueueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceQueueController {

    private final ServiceQueueService serviceQueue;

    public ServiceQueueController(ServiceQueueService serviceQueue){
        this.serviceQueue = serviceQueue;
    }

    @GetMapping()
    public ServiceQueue getService(Long id){
        return serviceQueue.getServiceQueueById(id);
    }

    @GetMapping("/all")
    public List<ServiceQueue> getAllServices(){
       return serviceQueue.getAll();
    }

    @PostMapping
    public String createService(String serviceName){
        serviceQueue.newService(serviceName);
        return serviceName + " is created";
    }
}
