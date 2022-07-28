package cvut.fel.service;

import cvut.fel.entity.Contract;
import org.springframework.stereotype.Component;

@Component
public interface ContractService {

    Contract findById(Long id);

}
