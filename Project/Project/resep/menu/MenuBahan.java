package resep.menu;

import java.util.ArrayList;
import resep.models.Menu;
import resep.utils.ScreenHelper;
import resep.models.Bahan;

public class MenuBahan extends Menu {
    ArrayList<Bahan> data;

    public MenuBahan(ArrayList<Bahan> data) {
        this.data = data;
    }

    @Override
    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                  DATA BAHAN                  |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Bahan                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Bahan                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Edit Bahan                               |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Bahan                              |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Kembali                                 |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...4) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    tampilData();
                    break;
                case 2:
                    tambah();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    hapus();
                    break;
                case 0:
                    System.out.println("+=============================================+");
                    System.out.println("|            KEMBALI KE MENU UTAMA            |");
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
        if (data.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|               TAMPIL DATA BAHAN              |");
            System.out.println("+=============================================+");
            for (Bahan tempBahan : data) {
                System.out.println("Kode Bahan      : " + tempBahan.getKode());
                System.out.println("Nama Bahan      : " + tempBahan.getNama());
                System.out.println("Kategori Bahan  : " + tempBahan.getKategori());
                System.out.println("Jumlah Stok     : " + tempBahan.getJumlah());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data bahan kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    @Override
    public int pilih() {
        ScreenHelper.clearConsole();
        String kodeBuku = "";
        int bukuDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                  PILIH BAHAN                |");
                System.out.println("+=============================================+");
                for (Bahan tempBahan : data) {
                System.out.println("Kode Bahan      : " + tempBahan.getKode());
                System.out.println("Nama Bahan      : " + tempBahan.getNama());
                System.out.println("Kategori Bahan  : " + tempBahan.getKategori());
                System.out.println("Jumlah Stok     : " + tempBahan.getJumlah());
                System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih kode bahan : ");
                kodeBuku = input.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getKode().equals(kodeBuku)) {
                        bukuDipilih = i;
                        break;
                    }
                }
            } while (bukuDipilih == -1);
        } else {
            System.out.println("Data buku kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return bukuDipilih;
    }

    @Override
    public void tambah() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|               TAMBAH DATA BAHAN              |");
        System.out.println("+=============================================+");
        Bahan tempBahan = new Bahan();
        System.out.print("Kode Bahan      : ");
        tempBahan.setKode(input.nextLine());
        System.out.print("Nama Bahan      : ");
        tempBahan.setNama(input.nextLine());
        System.out.print("Kategori Bahan  : ");
        tempBahan.setKategori(input.nextLine());
        System.out.print("Jumlah Stok     : ");
        tempBahan.setJumlah(input.nextInt());
        data.add(tempBahan);
        System.out.println("+=============================================+");
        System.out.println("|              DATA BAHAN TERSIMPAN           |");
        System.out.println("+=============================================+");
        input.nextLine();
        input.nextLine();
    }

    @Override
    public void edit() {
        ScreenHelper.clearConsole();
        int indexBahan = pilih();
        if (indexBahan != -1) {
            Bahan editBahan = data.get(indexBahan);
            System.out.println("+=============================================+");
            System.out.println("|                EDIT DATA BAHAN              |");
            System.out.println("+=============================================+");
            System.out.print("Kode Bahan      : ");
            editBahan.setKode(input.nextLine());
            System.out.print("Nama Bahan      : ");
            editBahan.setNama(input.nextLine());
            System.out.print("Kategori Bahan  : ");
            editBahan.setKategori(input.nextLine());
            System.out.print("Jumlah Stok     : ");
            editBahan.setJumlah(input.nextInt());
            data.set(indexBahan, editBahan);
            System.out.println("+=============================================+");
            System.out.println("|              DATA BAHAN TERSIMPAN           |");
            System.out.println("+=============================================+");
            input.nextLine();
            input.nextLine();
        }
    }

    public void hapus() {
        ScreenHelper.clearConsole();
        int indexBahan = pilih();
        if (indexBahan != -1) {
            data.remove(indexBahan);
            System.out.println("+=============================================+");
            System.out.println("|               DATA BAHAN DIHAPUS            |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

}
