package com.internsathi.springwebapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Assignments {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    private String description;

	    private LocalDate dueDate;

	    private boolean completed;

		public Assignments() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Assignments(String title, String description, LocalDate dueDate, boolean completed) {
			super();
			this.title = title;
			this.description = description;
			this.dueDate = dueDate;
			this.completed = completed;
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

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		public boolean isCompleted() {
			return completed;
		}

		public void setCompleted(boolean completed) {
			this.completed = completed;
		}

		@Override
		public String toString() {
			return "Assignments [id=" + id + ", title=" + title + ", description=" + description + ", dueDate="
					+ dueDate + ", completed=" + completed + "]";
		}
	    
	    
}
