package emsi.org.DigitalBankingBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Spécifie la valeur du discriminant utilisée pour distinguer cette sous-classe (CurrentAccount) lors de l'utilisation de l'héritage
@DiscriminatorValue("CA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends BankAccount {
    private double overDraft;
}
