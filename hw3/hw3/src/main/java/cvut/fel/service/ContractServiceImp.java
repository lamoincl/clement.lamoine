package cvut.fel.service;

import cvut.fel.entity.Contract;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImp implements ContractService {

    private final ContractRepository repository;

    @Autowired
    public ContractServiceImp(ContractRepository customerRepository) {
        this.repository = customerRepository;
    }

    public Contract findById(Long id){

        if (id == null)
            throw new FieldMissingException();
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contract_NOT_FOUND"));
    }

}
