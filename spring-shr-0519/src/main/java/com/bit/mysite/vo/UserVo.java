package com.bit.mysite.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {                                                                                                                                               
                                                                                                                                                                    
	private int usersNo;           
	
	@NotEmpty
	@Length(min=2, max=10)
	private String usersName;   
	
	@NotEmpty
	@Email
	private String email;    
	
	@NotEmpty
	@Pattern(regexp="^[0-9]+$")
	private String password;                
	
	private String gender;                                                                                                                                          
	private String regDate;                                                                                                                                         
	private String usersType;          
	
	
	public int getUsersNo() {                                                                                                                                       
		return usersNo;                                                                                                                                             
	}                                                                                                                                                               
	public void setUsersNo(int usersNo) {                                                                                                                           
		this.usersNo = usersNo;                                                                                                                                     
	}                                                                                                                                                               
	public String getUsersName() {                                                                                                                                  
		return usersName;                                                                                                                                           
	}                                                                                                                                                               
	                                                                                                                                                           
	public void setUsersName(String usersName) {                                                                                                                    
		this.usersName = usersName;                                                                                                                                 
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
	public String getGender() {                                                                                                                                     
		return gender;                                                                                                                                              
	}                                                                                                                                                               
	public void setGender(String gender) {                                                                                                                          
		this.gender = gender;                                                                                                                                       
	}                                                                                                                                                               
	public String getRegDate() {                                                                                                                                    
		return regDate;                                                                                                                                             
	}                                                                                                                                                               
	public void setRegDate(String regDate) {                                                                                                                        
		this.regDate = regDate;                                                                                                                                     
	}                                                                                                                                                               
	public String getUsersType() {                                                                                                                                  
		return usersType;                                                                                                                                           
	}                                                                                                                                                               
	public void setUsersType(String usersType) {                                                                                                                    
		this.usersType = usersType;                                                                                                                                 
	}                                                                                                                                                               
	                                                                                                                                                                
	@Override                                                                                                                                                       
	public String toString() {                                                                                                                                      
		return "UserVo [usersNo=" + usersNo + ", usersName=" + usersName + ", email=" + email + ", password=" + password                                            
				+ ", gender=" + gender + ", regDate=" + regDate + ", usersType=" + usersType + "]";                                                                 
	}                                                                                                                                                               
	                                                                                                                                                                
}                                                                                                                                                                   
                                                                                                                                                                    