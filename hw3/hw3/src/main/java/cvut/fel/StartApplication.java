package cvut.fel;

import cvut.fel.entity.Account;
import cvut.fel.entity.Contract;
import cvut.fel.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Contract customer1 = new Contract(125874561L);
        Contract customer2 = new Contract(255451616L);
        Contract customer3 = new Contract(125484538L);
        contractRepository.save(customer1);
        contractRepository.save(customer2);
        contractRepository.save(customer3);
        System.out.println("\nfindAll()");
        contractRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindByName('Paulo')");
        contractRepository.findByName("Paulo").forEach(System.out::println);

        Account account1 = new Account("Porek", 500);
        Account account2 = new Account("Kant1", 55);
        Account account3 = new Account("Clement", 1000);
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);
        System.out.println("\nfindAll()");
        accountRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindById(2L)");
        accountRepository.findById(2L).ifPresent(System.out::println);
    }

}