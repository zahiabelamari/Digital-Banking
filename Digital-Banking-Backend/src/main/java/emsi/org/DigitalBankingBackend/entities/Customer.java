package emsi.org.DigitalBankingBackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    // Spécifie la stratégie de génération de valeurs pour la clé primaire. Dans ce cas, la génération se fait de manière automatique.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer")
    // Spécifie l'accès en écriture seulement lors de la sérialisation/désérialisation JSON.
    // Cela signifie que les détails des comptes bancaires ne seront pas renvoyés lors de la sérialisation JSON de l'objet Customer
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BankAccount> bankAccounts;
}
