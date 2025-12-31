package com.substring.helpdesk.tools;

import com.substring.helpdesk.entity.Priority;
import com.substring.helpdesk.entity.Status;
import com.substring.helpdesk.entity.Ticket;
import com.substring.helpdesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {


    private final TicketService ticketService;

    //create Ticket tool
    @Tool(description = "Create a new help desk ticket")
    public Ticket createTicketTool(
            @ToolParam(description = "User email") String email,
            @ToolParam(description = "Issue description") String description,
            @ToolParam(description = "Short summary") String summary,
            @ToolParam(description = "Ticket category") String category,
            @ToolParam(description = "Ticket priority: LOW, MEDIUM, HIGH") Priority priority
    ) {
        System.out.println("🔥 CREATE TICKET TOOL CALLED 🔥");
        Ticket ticket = Ticket.builder()
                .email(email)
                .description(description)
                .summary(summary)
                .category(category)
                .priority(priority)
                .status(Status.OPEN)
                .build();

        System.out.println("Going to create ticket: " + ticket);
        return ticketService.createTicket(ticket);
    }


    //get ticket using username
    @Tool(description = "This tool helps to get ticket by email.")
    public Ticket getTicketByUserName(@ToolParam(description = "email whose ticket is required. ")String email){
        return ticketService.getTicketByUserName(email);
    }

    @Tool(description = "This tool help to update ticket.")
    public Ticket updateTicket(@ToolParam(description = "new ticket fields required to update with ticket id.") Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    //get current system time
    @Tool(description = "This tool help to get current system time.")
    public String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }

}