package africa.box.dm.service.dkbs;

public class TransacObjet {

    private String Id_cl;
    private String Code_ctr;
    private String ctr;
    private String sign_trans;

    public String getCode_ctr() {
        return Code_ctr;
    }

    public void setCode_ctr(String code_ctr) {
        Code_ctr = code_ctr;
    }

    public String getCtr() {
        return ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public String getId_cl() {
        return Id_cl;
    }

    public void setId_cl(String id_cl) {
        Id_cl = id_cl;
    }

    public String getSign_trans() {
        return sign_trans;
    }

    public void setSign_trans(String sign_trans) {
        this.sign_trans = sign_trans;
    }



    @Override
    public String toString() {
        return "TransacObjet{" +
                "Id_cl='" + Id_cl + '\'' +
                ", Code_ctr='" + Code_ctr + '\'' +
                ", ctr='" + ctr + '\'' +
                ", sign_trans='" + sign_trans + '\'' +
                '}';
    }

    public TransacObjet() {
    }
    public TransacObjet(String id_cl, String code_ctr, String ctr, String sign_trans) {
        Id_cl = id_cl;
        Code_ctr = code_ctr;
        this.ctr = ctr;
        this.sign_trans = sign_trans;
    }
}
