package com.cd.bookapi.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class BookModel {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Size(min = 5, max = 200)
	    private String title;
	    @Size(min = 5, max = 200)
	    private String description;
	    @Size(min = 3, max = 40)
	    private String language;
	    @Min(100)
	    private Integer numberOfPages;
	    // Esto no permitirá que el campo createdAt sea modificado después de su creación.
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    public BookModel() {
	    }
	    public BookModel(String title, String desc, String lang, int pages) {	        
	    	this.title = title;
	        this.description = desc;
	        this.language = lang;
	        this.numberOfPages = pages;
	    }
	    public BookModel(Long id, String title, String desc, String lang, int pages) {
	        this.id = id;
	    	this.title = title;
	        this.description = desc;
	        this.language = lang;
	        this.numberOfPages = pages;
	    }
	    
	    // Otros getters y setters fueron removidos para resumir
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public Integer getNumberOfPages() {
			return numberOfPages;
		}
		public void setNumberOfPages(Integer numberOfPages) {
			this.numberOfPages = numberOfPages;
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
