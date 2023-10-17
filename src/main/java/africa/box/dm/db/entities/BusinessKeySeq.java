package africa.box.dm.db.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table( name = "businesskey_seq")
public class BusinessKeySeq implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identifiant;
    private String currentLetters;
    private Integer currentLettersCode;
    private Integer currentNumber;

    @Override
    public String toString() {
        return "BusinessKeySeq{" +
                "identifiant=" + identifiant +
                ", currentLetters='" + currentLetters + '\'' +
                ", currentLettersCode='" + currentLettersCode + '\'' +
                ", currentNumber=" + currentNumber +
                '}';
    }

    public BusinessKeySeq(Integer identifiant, String currentLetters, Integer currentLettersCode, Integer currentNumber) {
        this.identifiant = identifiant;
        this.currentLetters = currentLetters;
        this.currentLettersCode = currentLettersCode;
        this.currentNumber = currentNumber;
    }

    public BusinessKeySeq() {
    }

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public String getCurrentLetters() {
        return currentLetters;
    }

    public void setCurrentLetters(String currentLetters) {
        this.currentLetters = currentLetters;
    }

    public Integer getCurrentLettersCode() {
        return currentLettersCode;
    }

    public void setCurrentLettersCode(Integer currentLettersCode) {
        this.currentLettersCode = currentLettersCode;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

}
