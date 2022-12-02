package com.example.securitypgsql.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users", schema = "public")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 50, unique = true)
	private String email;
	
	@Column(length = 64)
    private String password;
	
	@ManyToOne()
	@JoinColumn(name = "user_role")
	private Role role;

	public Integer getId() {
		return id;
	}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}