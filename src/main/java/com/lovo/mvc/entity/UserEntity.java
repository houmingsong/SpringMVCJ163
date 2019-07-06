package com.lovo.mvc.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * UserEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_user")

public class UserEntity{


    // Fields    

     private String userId;
     private String userName;
     private String password;
     private Set<PowerEntity> power;

   
    // Property accessors
    @GenericGenerator(name="useruuid", strategy="uuid")@Id @GeneratedValue(generator="useruuid")
    
    @Column(name="user_id", unique=true, nullable=false, length=32)

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="user_name", length=64)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="user_password", length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity(String userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy="user")
	public Set<PowerEntity> getPower() {
		return power;
	}

	public void setPower(Set<PowerEntity> power) {
		this.power = power;
	}

}