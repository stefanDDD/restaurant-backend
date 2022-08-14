package com.ibm.restaurant.domain.tables;

import com.ibm.restaurant.domain.reservations.Reservation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "TABLES")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TABLE_ID")
    private Long id;

    @Column(name = "CAPACITY")
    private String capacity;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
