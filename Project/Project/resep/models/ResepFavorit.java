package resep.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class ResepFavorit {
    private String idResepFavorit;
    private LocalDateTime tanggalDitambahkan;
    private Resep resep;
    private User user;

    public ResepFavorit(Resep resep, User user) {
        this.idResepFavorit = UUID.randomUUID().toString();
        this.resep = resep;
        this.user = user;
        this.tanggalDitambahkan = LocalDateTime.now();
    }

    public String getIdResepFavorit() {
        return idResepFavorit;
    }

    public LocalDateTime getTanggalDitambahkan() {
        return tanggalDitambahkan;
    }

    public Resep getResep() {
        return resep;
    }

    public void setResep(Resep resep) {
        this.resep = resep;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
