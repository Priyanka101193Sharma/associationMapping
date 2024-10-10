package in.priyankait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.priyankait.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

}
