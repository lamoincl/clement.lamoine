package cvut.fel.dto;

import cvut.fel.entity.Contract;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.List;

@Getter
@Setter
public class AccountDTO extends AbstractDTO{
    public String name;
    public long depositAmount;
    public List<ContractDTO> contractDTOList;

    public AccountDTO() {
    }

    public AccountDTO(AccountDTO dto) {
        super(dto);
        depositAmount = dto.getDepositAmount();
        contractDTOList = dto.getContractDTOList();
    }

    @Override
    public AbstractDTO clone() {
        return new AccountDTO(this);
    }

}
