package resep.menu;

import java.util.ArrayList;
import resep.models.Menu;
import resep.models.Resep;
import resep.models.ResepFavorit;
import resep.models.User;
import resep.utils.ScreenHelper;

public class MenuResepFavorit extends Menu {
    private ArrayList<ResepFavorit> dataResepFavorit;
    private ArrayList<Resep> dataResep;
    private User userAktif;

    public MenuResepFavorit(ArrayList<ResepFavorit> dataResepFavorit, ArrayList<Resep> dataResep, User userAktif) {
        this.dataResepFavorit = dataResepFavorit;
        this.dataResep = dataResep;
        this.userAktif = userAktif;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|              MENU RESEP FAVORIT             |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Resep Favorit                    |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Resep Favorit                    |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Kembali                                 |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...2) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    tampilData();
                    break;
                case 2:
                    tambah();
                    break;
                case 0:
                    System.out.println("+=============================================+");
                    System.out.println("|             KEMBALI KE MENU UTAMA           |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia, silakan ulangi kembali.");
                    input.next();
            }
        } while (pilihan != 0);
    }

    @Override
    public void tampilData() {
        ScreenHelper.clearConsole();
        ArrayList<ResepFavorit> userFavorit = new ArrayList<>();
        for (ResepFavorit favorit : dataResepFavorit) {
            if (favorit.getUser().equals(userAktif)) {
                userFavorit.add(favorit);
            }
        }
        
        if (userFavorit.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|             RESEP FAVORIT SAYA              |");
            System.out.println("+=============================================+");
            for (ResepFavorit favorit : userFavorit) {
                System.out.println("ID Resep Favorit    : " + favorit.getIdResepFavorit());
                System.out.println("Nama Resep          : " + favorit.getResep().getNama());
                System.out.println("Tanggal Ditambahkan : " + favorit.getTanggalDitambahkan());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Anda belum memiliki resep favorit.");
            input.nextLine();
        }
    }

    @Override
    public void tambah() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH RESEP FAVORIT            |");
        System.out.println("+=============================================+");

        System.out.println("Silahkan pilih resep yang ingin ditambahkan ke favorit");
        for (int i = 1; i < dataResep.size(); i++) {
            Resep resep = dataResep.get(i);
            System.out.println(i + ". " + resep.getNama());
        }
        System.out.print("Masukkan nomor resep: ");
        int indexResep = input.nextInt();
        input.nextLine();

        if (indexResep >= 0 && indexResep < dataResep.size()) {
            Resep resepDipilih = dataResep.get(indexResep);
            ResepFavorit favoritBaru = new ResepFavorit(resepDipilih, userAktif);
            dataResepFavorit.add(favoritBaru);
            System.out.println("+=============================================+");
            System.out.println("|        RESEP FAVORIT BERHASIL DITAMBAHKAN   |");
            System.out.println("+=============================================+");
            input.nextLine();
        } else {
            System.out.println("Pilihan tidak valid. Silahkan ulangi.");
            input.nextLine();
        }
    }

    @Override
    public void hapus() {
        // Implementasi metode hapus jika diperlukan
    }

    @Override
    public int pilih() {
        // Implementasi metode pilih jika diperlukan
        return 0;
    }

    @Override
    public void edit() {
        // Implementasi metode edit jika diperlukan
    }
}
