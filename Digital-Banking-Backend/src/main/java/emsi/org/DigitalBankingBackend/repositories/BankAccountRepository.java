package emsi.org.DigitalBankingBackend.repositories;

import emsi.org.DigitalBankingBackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
