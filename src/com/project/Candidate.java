package com.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="candidate")
	public class Candidate {
		@Id
	    @GeneratedValue
		@Column(name="can_id")
	    private Integer id;
	     
		@Column(name="can_name")
	    private String canName;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getCanName() {
			return canName;
		}

		public void setCanName(String canName) {
			this.canName = canName;
		}


}
