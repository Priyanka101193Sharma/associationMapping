package in.priyankait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.priyankait.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
