package in.priyankait.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.priyankait.entity.Person;
import in.priyankait.entity.PhoneNumber;
import in.priyankait.repo.IPersonRepository;
import in.priyankait.repo.IPhoneNumberRepository;

@Service("OtoMService")
public class OtoMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public void saveDataUsingParent() {
		//create parent object
		Person per=new Person("raja","delhi");
		//create child object
		PhoneNumber ph1=new PhoneNumber(9999999999L,"airtel","personal");
		PhoneNumber ph2=new PhoneNumber(8888888888L,"Jio","office");
		
		//add parent to child
		ph1.setPerson(per);
		ph2.setPerson(per);
		
		//add child to parent
		Set<PhoneNumber>phonesSet=new HashSet();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save the parent object
		personRepo.save(per);
		System.out.println("Person and his associated phoneNumbers are saved(P to C)");
	}

	@Override
	public void saveDataUsingChild() {
		//create parent obj
				Person per=new Person("ramesh","Mumbai");
				//create child obj
				PhoneNumber ph1=new PhoneNumber(7777777777L,"airtel","personal");
				PhoneNumber ph2=new PhoneNumber(6666666666L,"Jio","office");
				
				//add parent to child
				ph1.setPerson(per);
				ph2.setPerson(per);
				
				//add child to parent
				Set<PhoneNumber>phonesSet=new HashSet();
				phonesSet.add(ph1);
				phonesSet.add(ph2);
				per.setContactDetails(phonesSet);
				
				//save the parent object
				phoneRepo.save(ph1);
				phoneRepo.save(ph2);
				System.out.println("Person and his associated phoneNumbers are saved(C to P)");

	}

	@Override
	public void LoadDataUsingParent() {
		Iterable<Person> it=personRepo.findAll();
		it.forEach(per->{System.out.println("Parent::"+per);
		});

	}

}
