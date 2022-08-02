package com.ibm.restaurant.domain.tables;

import java.util.Objects;

public class Tables {

    private Long id;
    private String capacity;
    private String status;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tables table = (Tables) o;
        return Objects.equals(id, table.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", capacity='" + capacity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
