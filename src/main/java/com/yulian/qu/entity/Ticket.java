package com.yulian.qu.entity;

import com.yulian.qu.entity.enums.TicketState;
import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private TicketState ticketState;

    @ManyToOne
    @JoinColumn(name = "service_queue_id")
    private ServiceQueue serviceQueue;

    private int number;

    public ServiceQueue getServiceQueue() {
        return serviceQueue;
    }

    public void setServiceQueue(ServiceQueue serviceQueue) {
        this.serviceQueue = serviceQueue;
    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }
}
