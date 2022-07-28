package cvut.fel.service;

import cvut.fel.entity.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {

    Account findById(Long id);

}
