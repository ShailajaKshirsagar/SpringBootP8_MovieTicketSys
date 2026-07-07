package com.booking.controller;

import com.booking.entity.Ticket;
import com.booking.service.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController
{
    //inject service in this class
    @Autowired
    private TicketService ticketService;

    //add data api
    @PostMapping("/addTicket")
    public ResponseEntity<String> addData(@RequestBody Ticket ticket){
        ticketService.saveTicket(ticket);
        return new ResponseEntity<>("Ticket Booked", HttpStatus.CREATED);
    }

    //get all data api
    @GetMapping("/getAllData")
    public ResponseEntity<List<Ticket>> getAllTicket(){
        List<Ticket> ticketList = ticketService.getAllTicketData();
        return new ResponseEntity<>(ticketList,HttpStatus.OK);
    }

    //get data by id api
    @GetMapping("/getById/{id}")
    public ResponseEntity<Ticket> getDataById(@PathVariable int id){
        Ticket ticketbyid = ticketService.getTicketById(id);
        return new ResponseEntity<>(ticketbyid,HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") int id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>("Ticket deleted",HttpStatus.OK);
    }

    //update api aaded
    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("id")int id,@RequestBody Ticket ticket){
        Ticket updateTicket = ticketService.updateTicket(id,ticket);
        return new ResponseEntity<>(updateTicket,HttpStatus.OK);
    }

    //add List api added
    @PostMapping("/addListData")
    public ResponseEntity<String> addList(@RequestBody List<Ticket> ticketList){
        ticketService.saveListTicket(ticketList);
        return new ResponseEntity<>("List added",HttpStatus.OK);
    }
}
