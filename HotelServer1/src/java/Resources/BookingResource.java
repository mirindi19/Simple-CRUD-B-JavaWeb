/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Model.Booking;
import controller.Bookingcontroller;
import dao.GenericDao;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author BIENVENU
 */
@Path("booking")
public class BookingResource {
      GenericDao dao = new GenericDao(Booking.class);
       Bookingcontroller  bc = new Bookingcontroller();
       
       @POST
    public void create(Booking booking) {
        bc.Insert(booking);
      
    }
     @GET
    public List<Booking> getResult() {
        List<Booking> booking = dao.listAll();
        return booking;
    }
    
      @GET
    @Path("{id}")
    public Booking getBooking(@PathParam("id") Long id){
       Booking booking = (Booking) dao.findByLong_PK(id);
        if (booking != null) {
            return booking;
        }
       return null;
    }
    
      @PUT
    public void update(Booking booking){
        bc.Update(booking);
    }
    
        @DELETE
    @Path("{id}")
    public Booking deleteBooking(@PathParam("id") Long id) {
      Booking booking = (Booking) dao.findByLong_PK(id);
        if (booking != null) {
                bc.delete(booking);
                return booking;
            }
        return null;
    }
      
}
