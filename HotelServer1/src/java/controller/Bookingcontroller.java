/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Booking;
import dao.GenericDao;

/**
 *
 * @author BIENVENU
 */
public class Bookingcontroller {
                GenericDao dao = new GenericDao(Booking.class);
       public void Insert(Booking booking){
           dao.create(booking);
    } 
          public void delete(Booking booking){
           dao.delete(booking);
    } 
          
         public void Update(Booking booking){
           dao.update(booking);
    } 
}
