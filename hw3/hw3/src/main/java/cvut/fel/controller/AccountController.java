package cvut.fel.controller;

import cvut.fel.dto.AccountContractDTO;
import cvut.fel.dto.AccountDTO;
import cvut.fel.dto.ContractDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.facade.AggregateFacade;
import cvut.fel.service.AccountService;
import cvut.fel.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    private final AccountService accountService;
    private final ContractService contractService;
    private final DTOMapper dtoMapper;

    private final AggregateFacade aggregateFacade;

    @Autowired
    public AccountController(AccountService accountService, DTOMapper dtoMapper, ContractService contractService, AggregateFacade aggregateFacade) {
        this.accountService = accountService;
        this.dtoMapper = dtoMapper;
        this.contractService = contractService;
        this.aggregateFacade = aggregateFacade;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> getCustomerById(@PathVariable Long id) {
       return ResponseEntity.ok(dtoMapper.accountToDto(accountService.findById(id)));
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<ContractDTO> getContractById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.contractDto(contractService.findById(id)));
    }

    @GetMapping("/aggregate/account-contract")
    public ResponseEntity<AccountContractDTO> getAccountContract(@RequestParam Long accountId, @RequestParam Long contractId) {
        return ResponseEntity.ok(aggregateFacade.aggregateAccountContract(accountId, contractId));
    }
}
