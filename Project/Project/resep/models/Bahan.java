package resep.models;

public class Bahan {
    private String kode, nama, kategori;
    private int jumlah;

    public Bahan(){};
    
    public Bahan(String kode, String nama, String kategori, int jumlah) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah = jumlah;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public boolean pinjam(int jumlah){
        if(this.jumlah-jumlah>=0){
            this.jumlah -= jumlah;
            return true;
        } else {
            return false;
        }
    }
}
