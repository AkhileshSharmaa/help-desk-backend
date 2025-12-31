package com.substring.helpdesk.service;


import com.substring.helpdesk.entity.Ticket;
import com.substring.helpdesk.respository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    //create
    @Transactional
    public Ticket createTicket(Ticket ticket){
        // REMOVED THE "existing" CHECK so we can create new tickets
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    //update
    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    //get ticket logic
    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    //logic ticket by username
    public Ticket getTicketByUserName(String email){
        return ticketRepository.findByEmail(email).orElse(null);
    }
}
