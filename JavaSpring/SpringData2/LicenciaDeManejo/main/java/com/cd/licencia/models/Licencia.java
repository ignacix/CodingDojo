package com.cd.licencia.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="licencia")
public class Licencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private Integer number;
    
    @Future(message="la fecha debe ser mayor a la actual")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;
    @NotBlank
    private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
    
    public Licencia() {
    	
    }
    
    @PrePersist
    public void createdAt() {
    	this.createdAt = new Date();
    }
    
    @PreUpdate
    public void updatedAt() {
    	this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {			
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public String getExpirationDateFormateado() {
		SimpleDateFormat fechaFormateada = new SimpleDateFormat("MM/dd/yyyy");
		return String.valueOf(fechaFormateada.format(this.expirationDate) ) ;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	//METODOS DE LA CLASE
	
	public String getNumberComoString() {
		int cantidadCeros = 5 - String.valueOf(this.getNumber()).length();
		String cadena= "";
		
		for(int i=0; i<cantidadCeros; i++){
			cadena = cadena +'0';
		}		
		return cadena + String.valueOf(this.getNumber()); 
	}
	
	
    
}
