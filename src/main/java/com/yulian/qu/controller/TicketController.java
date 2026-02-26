package com.yulian.qu.controller;

import com.yulian.qu.entity.Ticket;
import com.yulian.qu.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public String getTicketStatus(Long id){
        return ticketService.ticketStatus(id);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketService.allTickets();
    }

    @PutMapping
    public String createTicket(Long id){
        return ticketService.createTicket(id);
    }

    @GetMapping("/next")
    public Ticket getNextTicket(){
        return ticketService.getNextTicket();
    }

    @PostMapping()
    public String calledNextTicket(Long id){
        return ticketService.callTicket(id);
    }

}
