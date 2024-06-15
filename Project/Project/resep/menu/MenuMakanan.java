package resep.menu;

import java.util.ArrayList;
import java.util.Scanner;

import resep.models.Makanan;
import resep.models.Resep;
import resep.models.Resep.JenisMakanan;
import resep.utils.ScreenHelper;

public class MenuMakanan {
    private ArrayList<Makanan> data;
    private Scanner input;

    public MenuMakanan(ArrayList<Makanan> data) {
        this.data = data;
        this.input = new Scanner(System.in);
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                 DATA MAKANAN                |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Appetizer                        |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tampil Main Course                      |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Tampil Dessert                          |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Tambah Resep                            |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Kembali                                 |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...4) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    tampilData(JenisMakanan.APPETIZER);
                    break;
                case 2:
                    tampilData(JenisMakanan.MAIN_COURSE);
                    break;
                case 3:
                    tampilData(JenisMakanan.DESSERT);
                    break;
                case 4:
                    tambah();
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

    public void tampilData(JenisMakanan jenis) {
        ScreenHelper.clearConsole();
        Makanan makanan = data.stream().filter(m -> m.getJenis() == jenis).findFirst().orElse(null);
        if (makanan != null && makanan.getResepList().size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|              TAMPIL DATA MAKANAN            |");
            System.out.println("+=============================================+");
            for (Resep tempResep : makanan.getResepList()) {
                System.out.println("Nama Resep     : " + tempResep.getNama());
                System.out.println("Bahan-bahan    : " + tempResep.getBahan());
                System.out.println("Instruksi      : " + tempResep.getInstruksi());
                System.out.println("Pencipta       : " + tempResep.getPencipta());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Resep kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    public void tambah() {
        ScreenHelper.clearConsole();
        String nama, bahan, instruksi, pencipta;
        int jenis;
        System.out.println("+=============================================+");
        System.out.println("|               TAMBAH DATA RESEP             |");
        System.out.println("+=============================================+");
    
        System.out.print("Nama Resep     : ");
        nama = input.nextLine();
        System.out.print("Bahan-bahan    : ");
        bahan = input.nextLine();
        System.out.print("Instruksi      : ");
        instruksi = input.nextLine();
        System.out.print("Pencipta       : ");
        pencipta = input.nextLine();
        System.out.print("Jenis (1: Appetizer, 2: Main Course, 3: Dessert) : ");
        jenis = input.nextInt();
        input.nextLine();
    
        final JenisMakanan jenisMakanan;
        switch (jenis) {
            case 1:
                jenisMakanan = JenisMakanan.APPETIZER;
                break;
            case 2:
                jenisMakanan = JenisMakanan.MAIN_COURSE;
                break;
            case 3:
                jenisMakanan = JenisMakanan.DESSERT;
                break;
            default:
                System.out.println("Jenis makanan tidak valid.");
                return;
        }
    
        Resep resepBaru = new Resep(nama, bahan, instruksi, pencipta, jenisMakanan);
        Makanan makanan = data.stream().filter(m -> m.getJenis() == jenisMakanan).findFirst().orElse(null);
        if (makanan != null) {
            makanan.tambahResep(resepBaru);
        }
        System.out.println("+=============================================+");
        System.out.println("|               DATA RESEP TERSIMPAN          |");
        System.out.println("+=============================================+");
        input.nextLine();
    }    
}
