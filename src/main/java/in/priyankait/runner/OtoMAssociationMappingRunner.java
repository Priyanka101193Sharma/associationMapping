package in.priyankait.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.priyankait.service.IOToMAssociationMgmtService;

@Component
public class OtoMAssociationMappingRunner implements CommandLineRunner {
	@Autowired
	private IOToMAssociationMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.saveDataUsingParent();

	}

}
