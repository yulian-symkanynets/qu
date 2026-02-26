package com.yulian.qu.repository;

import com.yulian.qu.entity.Ticket;
import com.yulian.qu.entity.enums.TicketState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findFirstByTicketStateEquals(TicketState ticketState);
}
