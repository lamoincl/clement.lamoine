package cvut.fel.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findByName", query = "SELECT u FROM Account u WHERE u.name = :name"),
})
@Getter
@Setter
public class Account extends AbstractEntity {
    @NotNull
    public long depositAmount = 0;

    public Account() {

    }

    public Account(String name, long depositAmount) {
        this.name = name;
        this.depositAmount = depositAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + depositAmount + '\'' +
                '}';
    }
}
