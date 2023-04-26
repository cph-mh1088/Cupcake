package dat.backend.model.entities;

import java.sql.Timestamp;

public class Ordre {
    private int ordreId;
    private String brugernavn;
    private Timestamp dato;

    public Ordre(int ordreId, String brugernavn, Timestamp dato) {
        this.ordreId = ordreId;
        this.brugernavn = brugernavn;
        this.dato = dato;
    }

    public Ordre(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public void setDato(Timestamp dato) {
        this.dato = dato;
    }

    public int getOrdreId() {
        return ordreId;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public Timestamp getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return "Ordre{" +
                "ordreId=" + ordreId +
                ", brugernavn='" + brugernavn + '\'' +
                ", dato=" + dato +
                '}';
    }
}
