package resep.models;

import java.util.UUID;

public class Resep {
    public enum JenisMakanan {
        APPETIZER, MAIN_COURSE, DESSERT
    }

    private String id, nama, bahan, instruksi, pencipta;
    private JenisMakanan jenis;

    public Resep(String nama, String bahan, String instruksi, String pencipta, JenisMakanan jenis) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.bahan = bahan;
        this.instruksi = instruksi;
        this.pencipta = pencipta;
        this.jenis = jenis;
    }

    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getBahan() {
        return bahan;
    }
    public void setBahan(String bahan) {
        this.bahan = bahan;
    }
    public String getInstruksi() {
        return instruksi;
    }
    public void setInstruksi(String instruksi) {
        this.instruksi = instruksi;
    }
    public String getPencipta() {
        return pencipta;
    }
    public void setPencipta(String pencipta) {
        this.pencipta = pencipta;
    }
    public JenisMakanan getJenis() {
        return jenis;
    }
    public void setJenis(JenisMakanan jenis) {
        this.jenis = jenis;
    }
}
