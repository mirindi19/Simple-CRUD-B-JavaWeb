/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Model.Booking;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author BIENVENU
 */
@ManagedBean(name="bookingbean")
@SessionScoped
public class BookingBackingBean {
    Booking booking;

    public BookingBackingBean() {
        booking = new Booking();
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
      public String create() {
        booking.setPayment(booking.getAdult()*15000 + booking.getChildren()*10000);
        ClientBuilder.newClient().target("http://localhost:8080/HotelServer1/room/booking")
                    .request().post(Entity.json(booking));
                  FacesContext context = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
                session.setAttribute("booking", booking);
                return "ViewBooking.xhtml";
    }
            public List<Booking> getAll() {
        return ClientBuilder.newClient()
                .target("http://localhost:8080/HotelServer1/room/booking")
                .request().get(new GenericType<List<Booking>>() {
                });
    }
        
            
     public String findCheck(Long id){
                System.out.println("unknown");
        booking = ClientBuilder.newClient().target("http://localhost:8080/HotelServer1/room/booking/" + id)
               .request().get(new GenericType<Booking>(){});
        System.out.println("unknown");

        return "MyFacture";
    }
 
            public String update(){
         booking.setPayment(booking.getAdult()*15000 + booking.getChildren()*10000);
        ClientBuilder.newClient().target("http://localhost:8080/HotelServer1/room/booking")
            .request().put(Entity.json(booking));
         FacesContext context = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
                session.setAttribute("booking", booking);
                return "ViewBooking.xhtml";
    }

public String findUpdate(Long id){
                System.out.println("unknown");
        booking = ClientBuilder.newClient().target("http://localhost:8080/HotelServer1/room/booking/" + id)
               .request().get(new GenericType<Booking>(){});
        System.out.println("unknown");

        return "Checkview";
    }

    public String delete(Long id) {
        booking = ClientBuilder.newClient()
                .target("http://localhost:8080/HotelServer1/room/booking/" + id)
                .request().delete(Booking.class);
       if (booking != null) {
               return "Home";
        } else {
           
                return "Checkview";
       }
       
    }
}
