package com.bit.mysite.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 *  Form Validation (입력 유효성 검사)
 *  	- JSR-303(버전임) Validator를 확장한 Annotation 활용
 *  	- Bean Validation (빈 검증)	
 *  	- @Valid를 활용하여 자동 검증
 *  	- 모델 객체의 제약 조건을 Annotation을 통해 검증 가능
 *  	- Bean validation을 사용하기 위한 스프링 설정 
 *  		-> <mvc:annotation-driven /> 으로 함
 *  
 *   Hibernate (하이버네이트)
 *   	- 자바 기반의 객체 관계 매핑 프레임워크
 *   	- 주로 RDBMS와의 매핑을 위한 기능 제공
 *   	
 *   Hibernate 유효성 검사를 위한 어노테이션
 *   	@NotEmpty	: 비어있는지
 *   	@Email		: 이메일 형식
 *   	@URL		: URL 형식
 *   	@Length		: 문자열 길이 제한 (min, max)
 *   	@Range		: 숫자 범위 제한 (min, max)
 *   	@Pattern	: 정규 표현식을 활용해서 제한 
 */

// Value Object, Model Object
public class UserVo {
	private Long no;
	
	@NotEmpty
	@Length(min=2, max=10)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp="^[0-9]+$")
	private String password;
	
	private String gender;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender + "]";
	}
	
	
	
}
