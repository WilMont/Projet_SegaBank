package bo;

public class Agence {

    private int id;
    private int code;
    private int adresse;

    public Agence(int id, int code, int adresse) {
        this.id = id;
        this.code = code;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }
}
