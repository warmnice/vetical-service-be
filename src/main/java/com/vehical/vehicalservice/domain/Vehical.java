package com.vehical.vehicalservice.domain;
import jakarta.persistence.*;

@Entity
public class Vehical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Column(length = 6, nullable = false)
    private String cname;

    @Column(length = 6, nullable = false)
    private String ccolor;

    @Column(nullable = false)
    private int cprice;

    @Column(nullable = false)
    private int cage;

    public Vehical(String cname, String ccolor, int cprice, int cage) {
        this.cname = cname;
        this.ccolor = ccolor;
        this.cprice = cprice;
        this.cage = cage;
    }

    public Vehical() {

    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getCcolor() {
        return ccolor;
    }

    public int getCprice() {
        return cprice;
    }

    public int getCage() {
        return cage;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCcolor(String ccolor) {
        this.ccolor = ccolor;
    }

    public void setCprice(int cprice) {
        this.cprice = cprice;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }
}