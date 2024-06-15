package resep.models;

import java.util.ArrayList;
import resep.models.Resep.JenisMakanan;

public class Makanan {
    private JenisMakanan jenis;
    private ArrayList<Resep> resepList;

    public Makanan(JenisMakanan jenis) {
        this.jenis = jenis;
        this.resepList = new ArrayList<>();
    }

    public JenisMakanan getJenis() {
        return jenis;
    }

    public ArrayList<Resep> getResepList() {
        return resepList;
    }

    public void tambahResep(Resep resep) {
        if (resep.getJenis() == this.jenis) {
            resepList.add(resep);
        } else {
            System.out.println("Resep tidak sesuai dengan jenis makanan.");
        }
    }
}
