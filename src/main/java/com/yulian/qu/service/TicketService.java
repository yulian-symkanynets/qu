package com.yulian.qu.service;

import com.yulian.qu.entity.ServiceQueue;
import com.yulian.qu.entity.Ticket;
import com.yulian.qu.entity.enums.TicketState;
import com.yulian.qu.repository.ServiceQueueRepository;
import com.yulian.qu.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ServiceQueueRepository serviceQueueRepository;

    public TicketService(TicketRepository ticketRepository, ServiceQueueRepository serviceQueueRepository) {
        this.ticketRepository = ticketRepository;
        this.serviceQueueRepository = serviceQueueRepository;
    }

    public String ticketStatus(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isEmpty()) {
            return "Ticket with id" + id + " not found";
        }
        return ticket.get().getTicketState().toString();
    }

    public List<Ticket> allTickets() {
        return ticketRepository.findAll();
    }

    public String createTicket(Long id) {
        Ticket ticket = new Ticket();
        ticket.setTicketState(TicketState.WAITING);
        Optional<ServiceQueue> serviceQueue = serviceQueueRepository.findById(id);
        serviceQueue.ifPresent(ticket::setServiceQueue);
        ticket.setNumber(20);
        ticketRepository.save(ticket);
        return "Ticket with " + ticket.getId() + " is created";
    }

    public Ticket getNextTicket() {
        Optional<Ticket> ticket = ticketRepository.findFirstByTicketStateEquals(TicketState.WAITING);
        return ticket.orElse(null);
    }

    public String callTicket(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        Ticket ticket;
        if (ticketOptional.isPresent()) {
            ticket = ticketOptional.get();
            ticket.setTicketState(TicketState.CALLED);
            ticketRepository.save(ticket);
            return "Ticket with id " + id + " is called";
        }
        return "Ticket with id " + id + " not found";
    }
}
