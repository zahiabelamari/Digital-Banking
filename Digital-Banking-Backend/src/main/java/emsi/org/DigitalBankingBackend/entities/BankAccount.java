package emsi.org.DigitalBankingBackend.entities;

import emsi.org.DigitalBankingBackend.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


// Indique que la classe est une entité persistante qui sera stockée dans une bdd
@Entity
// Spécifie la stratégie d'héritage de la classe, où toutes les sous-classes partagent une seule table de bdd
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Spécifie la colonne discriminante utilisée pour différencier les sous-classes lors de l'utilisation de l'héritage
@DiscriminatorColumn(name = "TYPE", length = 4)
// Génère automatiquement les méthodes getter, setter, equals, hashCode et toString pour la classe
@Data
// Constructeur par défaut sans arguments
@NoArgsConstructor
// Constructeur prenant tous les champs de la classe comme arguments
@AllArgsConstructor
public abstract class BankAccount {
    // Cette annotation indique que le champ est la clé primaire de l'entité
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    // Spécifie que le champ est mappé à une colonne de type enumération et que la valeur doit être stockée en tant que chaîne de caractères
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    // Relation many-to-one entre cette classe et la classe Customer
    @ManyToOne
    private Customer customer;
    // Relation one-to-many entre cette classe et la classe AccountOperation
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;
}
