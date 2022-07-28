package cvut.fel.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "contracts")
@NamedQueries({
        @NamedQuery(name = "Contract.findByName", query = "SELECT u FROM Contract u WHERE u.name = :name"),
})
@Getter
@Setter
public class Contract extends AbstractEntity {
    @Column(unique = true)
    @NotNull
    public Long number;

    @ManyToOne
    public Account account;
    public Contract(Long number) {
        this();
        this.number = number;
    }

    public Contract() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
