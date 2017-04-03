package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer20 on 4/2/17.
 */
@RestController
@RequestMapping("/flights")
public class JSONResponseController {

    @GetMapping("/flight")
    public Flight getFlight(){
        Flight flight1 = new Flight();
        Flight.Ticket ticket1 = new Flight.Ticket();
        Flight.Ticket.Person person1 = new Flight.Ticket.Person();
        person1.setFirstName("Some name");
        person1.setLastName("Some other name");
        ticket1.setPrice(200);
        ticket1.setPerson(person1);
        List<Flight.Ticket> tickets = new ArrayList<Flight.Ticket>();
        tickets.add(ticket1);
        flight1.setTickets(tickets);
        flight1.setDeparts(new Date());
        return flight1;
    }
    public static class Flight{

        private Date departs;
        private List<Ticket> tickets;

        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }

        @JsonFormat(pattern = "yyy-MM-dd HH:mm")
        public Date getDeparts() {
            return departs;
        }

        public void setDeparts(Date departs) {
            this.departs = departs;
        }

        public static class Ticket{

            private int price;
            private Person person;

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public Person getPerson() {
                return person;
            }

            public void setPerson(Person person) {
                this.person = person;
            }

            public static class Person{
                private String firstName;
                private String lastName;

                public String getFirstName() {
                    return firstName;
                }

                public void setFirstName(String firstName) {
                    this.firstName = firstName;
                }

                public String getLastName() {
                    return lastName;
                }

                public void setLastName(String lastName) {
                    this.lastName = lastName;
                }
            }

        }
    }

    @GetMapping
    public Object getFlights(){
        List<Flight> flights = new ArrayList<Flight>();

        //flight1
        Flight flight1 = new Flight();
        Flight.Ticket ticket1 = new Flight.Ticket();
        Flight.Ticket.Person person1 = new Flight.Ticket.Person();
        person1.setFirstName("Some name");
        person1.setLastName("Some other name");
        ticket1.setPrice(200);
        ticket1.setPerson(person1);
        List<Flight.Ticket> tickets = new ArrayList<Flight.Ticket>();
        tickets.add(ticket1);
        flight1.setTickets(tickets);
        flight1.setDeparts(new Date());

        flights.add(flight1);

        //flight2
        Flight flight2 = new Flight();
        Flight.Ticket ticket2 = new Flight.Ticket();
        Flight.Ticket.Person person2 = new Flight.Ticket.Person();
        person2.setFirstName("Some name1");
        person2.setLastName("Some other name1");
        ticket2.setPrice(300);
        ticket2.setPerson(person2);
        List<Flight.Ticket> tickets1 = new ArrayList<Flight.Ticket>();
        tickets1.add(ticket2);
        flight2.setTickets(tickets1);
        flight2.setDeparts(new Date());

        flights.add(flight2);

        return flights;
    }
}
