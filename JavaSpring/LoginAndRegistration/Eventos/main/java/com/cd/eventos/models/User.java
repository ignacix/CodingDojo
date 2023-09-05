package com.cd.eventos.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	  	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	  	
	  	@NotBlank(message="Por favor ingresa un nombre")
	  	@Size(min=3, max=30, message= "El nombre debe contener minimo 3 caracteres")
	    private String firstName;
	  	
	  	@NotBlank(message="Por favor ingresa un apellido")
	  	@Size(min=3, max=30, message= "El apellido debe contener minimo 3 caracteres")
	    private String lastName;
	  	
	  	
	  	@NotBlank(message="Por favor ingresa un correo electrónico")
	  	@Email(message="El ingreso")
	    private String email;
	  	
	  	@NotBlank(message="Por favor ingresa una location")
	  	@Size(min=3, max=30, message= "Location debe contener minimo 3 caracteres")
	    private String location;
	  	
	  	@NotBlank(message="Por favor ingresa una provincia")	 
	    private String provincia;
	  	
	  	
	  	@NotBlank(message="Por favor, ingresa el password")
	  	@Size(min=8, max=64, message= "Password debe contener minimo 8 caracteres")
	    private String password;
	    
	  	@Transient
	  	@NotBlank(message="Por favor, ingresa el password")
	  	@Size(min=8, max=64, message= "Password debe contener minimo 8 caracteres")
	    private String passwordConfirmation;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    //RELACION 1:N HACIA EVENTOS
	    @OneToMany(mappedBy = "organizador", fetch=FetchType.LAZY)
	    private List<EventModel> eventosOrganizados;
	    
	    
	    public User() {
	    }
	    
	    
	    // 
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
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


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}


		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
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


	    
	    
}