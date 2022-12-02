package com.example.securitypgsql.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="roles",schema="public")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "role")
	private List<User> users;
	
	@Column(name = "description", length = 30)
	private String description;
	
	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

    public void setDescription(String description) {
        this.description = description;
    }
	
}