package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "guests", schema = "nation", catalog = "")
public class GuestsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guest_id", nullable = false)
    private int guestId;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestsEntity that = (GuestsEntity) o;

        if (guestId != that.guestId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guestId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
