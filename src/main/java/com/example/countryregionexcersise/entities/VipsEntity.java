package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vips", schema = "nation", catalog = "")
public class VipsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vip_id", nullable = false)
    private int vipId;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
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

        VipsEntity that = (VipsEntity) o;

        if (vipId != that.vipId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vipId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
