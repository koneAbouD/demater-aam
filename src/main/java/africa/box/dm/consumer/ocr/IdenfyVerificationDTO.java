package africa.box.dm.consumer.ocr;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor
public class IdenfyVerificationDTO {

    private String authToken;
    @NotNull @NotEmpty
    private String country;

    @NotNull
    private IdenfyDcumentType documentType;

    @NotNull
    private Images images;


    public class Images {
        @NotEmpty(message = "FRONT est obligatoire")
        private String FRONT ;

        @NotEmpty(message = "BACK est Obligatoire")
        private String BACK;
        @NotEmpty(message = "FACE est obligatoire")
        private String FACE;

        public Images(){}

        public String getFRONT(){
            return FRONT;
        }

        public void setFRONT(String FRONT) {
            this.FRONT = FRONT;
        }

        public String getBACK() {
            return BACK;
        }

        public void setBACK(String BACK) {
            this.BACK = BACK;
        }

        public String getFACE() {
            return FACE;
        }

        public void setFACE(String FACE) {
            this.FACE = FACE;
        }
    }
}
