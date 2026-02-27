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

    @GetMapping()
    public String getTicketStatus(@RequestParam Long id) {
        return ticketService.ticketStatus(id);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.allTickets();
    }

    @PostMapping()
    public String createTicket(@RequestParam Long id) {
            return ticketService.createTicket(id);
    }

    @GetMapping("/next")
    public Ticket getNextTicket() {
        return ticketService.getNextTicket();
    }

    @PutMapping()
    public String calledNextTicket(@RequestParam Long id) {
        return ticketService.callTicket(id);
    }

}
