package africa.box.dm.service.dkbs;

import javax.persistence.Transient;

public class ResponseGetSign {
    private String status;

    @Transient
    private TransacObjet data;



    public void setStatuse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public TransacObjet getData() {
        return data;
    }

    public void setData(TransacObjet data) {
        this.data = data;
    }

    public ResponseGetSign() {
    }

    public ResponseGetSign(TransacObjet data,String status) {
        this.data = data;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseGetSign{" +
                "code='" + status + '\'' +
                ", data=" + data +
                '}';
    }


}
