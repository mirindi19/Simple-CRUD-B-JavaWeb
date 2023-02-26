/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author BIENVENU
 */
@Entity
public class Booking {
      private String name;
   @Id
   private Long passid;
   private String arrival;
   private String dep;
   private int adult;
   private int children;
   private int payment;

    public Booking() {
    }

    public Booking(String name, Long passid, String arrival, String dep, int adult, int children, int payment) {
        this.name = name;
        this.passid = passid;
        this.arrival = arrival;
        this.dep = dep;
        this.adult = adult;
        this.children = children;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPassid() {
        return passid;
    }

    public void setPassid(Long passid) {
        this.passid = passid;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

  
}
