package com.lovo.mvc.entity;

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
 * PowerEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_power")

public class PowerEntity{


    // Fields    

     private String powerId;
     private String powerName;
     
     private UserEntity user;

    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="power_id", unique=true, nullable=false, length=32)

    public String getPowerId() {
        return this.powerId;
    }
    
    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }
    
    @Column(name="power_name", length=64)

    public String getPowerName() {
        return this.powerName;
    }
    
    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
    
    @ManyToOne
	@JoinColumn(name="t_userId")
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
    
    
	
    
}