package cvut.fel.facade;

import cvut.fel.dto.AccountContractDTO;
import cvut.fel.entity.Account;
import cvut.fel.entity.Contract;
import cvut.fel.service.AccountService;
import cvut.fel.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class AggregateFacade {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ContractService contractService;

    public AccountContractDTO aggregateAccountContract(Long accountId, Long contractId) {
        Account account = accountService.findById(accountId);
        Contract contract = contractService.findById(contractId);

        return new AccountContractDTO(account.getName(), contract.getNumber(), account.getDepositAmount());
    }
}
