package cvut.fel.repository;

import cvut.fel.entity.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long> {

    List<Contract> findByName(String name);

}
