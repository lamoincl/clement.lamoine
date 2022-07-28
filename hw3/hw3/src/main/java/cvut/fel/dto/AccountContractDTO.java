package cvut.fel.dto;

public class AccountContractDTO extends AbstractDTO {
    public String name;
    public Long number;
    public Long depositAmount;

    public AccountContractDTO(String name, Long number, Long depositAmount) {
        this.name = name;
        this.number = number;
        this.depositAmount = depositAmount;
    }

    public AccountContractDTO(AccountContractDTO dto) {
        super(dto);
        name = dto.name;
        number = dto.number;
        depositAmount = dto.depositAmount;
    }
    @Override
    protected AbstractDTO clone() {
        return new AccountContractDTO(this);
    }
}
