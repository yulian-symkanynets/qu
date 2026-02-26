package com.yulian.qu.service;

import com.yulian.qu.entity.ServiceQueue;
import com.yulian.qu.entity.Ticket;
import com.yulian.qu.repository.ServiceQueueRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceQueueService {
    private final ServiceQueueRepository serviceRepository;

    public ServiceQueueService(ServiceQueueRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Transactional
    public void newService(String serviceName) {
        com.yulian.qu.entity.ServiceQueue service = new com.yulian.qu.entity.ServiceQueue();
        service.setName(serviceName);
        service.setAbbreviation(serviceName.toUpperCase().substring(0, 2));
        serviceRepository.save(service);
    }

    @Transactional
    public List<ServiceQueue> getAll() {
        return serviceRepository.findAll();
    }

    @Transactional
    public ServiceQueue getServiceQueueById(Long id) {
        Optional<ServiceQueue> serviceQueue = serviceRepository.findById(id);
        return serviceQueue.orElse(null);
    }
}
