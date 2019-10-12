package bo;

public class Agence {

    private int id;
    private int code;
    private String adresse;

    public Agence(){};

    public Agence(int id, int code, String adresse) {
        this.id = id;
        this.code = code;
        this.adresse = adresse;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
