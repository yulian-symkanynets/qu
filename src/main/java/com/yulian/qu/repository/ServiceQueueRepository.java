package com.yulian.qu.repository;

import com.yulian.qu.entity.ServiceQueue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceQueueRepository extends JpaRepository<ServiceQueue, Long> {
    Optional<ServiceQueue> findByName(String name);

}
