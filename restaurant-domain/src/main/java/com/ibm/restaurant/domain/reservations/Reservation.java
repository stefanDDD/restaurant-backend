package com.ibm.restaurant.domain.reservations;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TABLE_ID", nullable = false)
    private com.ibm.restaurant.domain.tables.Tables table;

    public com.ibm.restaurant.domain.tables.Tables getTable() {
        return table;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setTable(com.ibm.restaurant.domain.tables.Tables table) {
        this.table = table;
    }
}
