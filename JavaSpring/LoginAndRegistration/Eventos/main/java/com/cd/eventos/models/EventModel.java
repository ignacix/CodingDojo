package com.cd.eventos.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="eventos")
public class EventModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
  	
	
	@NotBlank(message="Por favor ingresa un nombre")
  	@Size(min=3, max=30, message= "El nombre debe contener minimo 3 caracteres")
    private String name;
  
	@Future(message = "Por favor ingresa una fecha posterior")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Por favor ingresa una fecha")
    private Date fecha;
  	
  	@NotBlank(message="Por favor ingresa una location")
  	@Size(min=3, max=30, message= "Location debe contener minimo 3 caracteres")
    private String location;
  	
  	@NotBlank(message="Por favor ingresa una provincia")	 
    private String provincia;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    //RELACION 1:N HACIA USUARIO
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User organizador;
    
    
    public EventModel(){
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getOrganizador() {
		return organizador;
	}
	public void setOrganizador(User organizador) {
		this.organizador = organizador;
	}
	              	
}
