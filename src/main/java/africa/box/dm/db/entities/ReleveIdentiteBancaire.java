package africa.box.dm.db.entities;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static java.sql.JDBCType.TIME;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ReleveIdentiteBancaire.TABLE_NAME)
@Access(AccessType.FIELD)
public class ReleveIdentiteBancaire {
    public static final String TABLE_NAME = "releve_identite_bancaire";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull(message = "The customerCode can't be null")
    private String customerCode;
    private String demandeur;
    @NotNull(message = "The accountCode can't be null")
    private String accountCode;
    @NotNull(message = "The iban can't be null")
    private String iban;
    private String branch;
    private String branchCode;
    private String cleRib;
    private String devise;
    private String codeBank;
    private String bic;
    private String adresse1;
    private String adresse2;

    @Override
    public String toString() {
        return "ReleveIdentiteBancaire{" +
                "id=" + id +
                ", customerCode='" + customerCode + '\'' +
                ", titulaire='" + demandeur + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", iban='" + iban + '\'' +
                ", branch='" + branch + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", key='" + cleRib + '\'' +
                ", devise='" + devise + '\'' +
                ", codeBank='" + codeBank + '\'' +
                '}';
    }
}
