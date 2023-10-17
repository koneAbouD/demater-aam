package africa.box.dm.dto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class DocumentEntryAddDto {
    private String docCode;
    @NotNull
    private String businessKey;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private int numberOfCopies=1;
    private Boolean confirmation=true;
    private Boolean facultatif=false;
//    private List<MetaDataDto> docMeta=new ArrayList<>();

    private String statut;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Boolean getFacultatif() {
        return facultatif;
    }

    public void setFacultatif(Boolean facultatif) {
        this.facultatif = facultatif;
    }
//
//    public List<MetaDataDto> getDocMeta() {
//        return docMeta;
//    }
//
//    public void setDocMeta(List<MetaDataDto> docMeta) {
//        this.docMeta = docMeta;
//    }
}
