package in.priyankait.entity;

import java.io.Serializable;
import java.util.Set;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="OTM_PERSON")
@Setter
@Getter
@RequiredArgsConstructor
public class Person implements Serializable{

	@Id
	@GeneratedValue
	private Integer pid;
	
	@Column(length=20)
	@NonNull
	private String pname;
	
	@Column(length=20)
	@NonNull
	private String paddrs;
	
	@OneToMany(targetEntity=PhoneNumber.class,cascade=CascadeType.ALL,
			       fetch=FetchType.LAZY,mappedBy="personInfo")
	private Set<PhoneNumber> contactDetails;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", contactDetails=" + contactDetails
				+ "]";
	}
	
	public Person() {
		System.out.println("Person:: 0-param Constructor");
	}

	
		
	
}
