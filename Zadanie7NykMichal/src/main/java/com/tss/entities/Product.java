package com.tss.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Reprezentuje produkt w systemie.")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unikalny identyfikator produktu", example = "1")
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    @Schema(description = "Nazwa produktu", example = "Komputer")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "price")
    @Schema(description = "Cena produktu", example = "1499.99")
    protected BigDecimal price;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Schema(description = "Data ostatniej aktualizacji produktu", example = "2025-05-01T12:00:00")
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "description")
    @Schema(description = "Opis produktu", example = "Wydajny PC.")
    private String description;

    // Gettery i settery
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tss.entities.Product[ id=" + id + " ]";
    }
    
}
