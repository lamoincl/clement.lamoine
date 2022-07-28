package cvut.fel.dto;

import cvut.fel.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class ContractDTO extends AbstractDTO{

    public Long number;
    public Account account;

    public ContractDTO() {
    }

    public ContractDTO(ContractDTO dto) {
        super(dto);
        number = dto.getNumber();
        account= dto.getAccount();
    }

    @Override
    public AbstractDTO clone() {
        return new ContractDTO(this);
    }

}
