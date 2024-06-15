package resep.menu;

import java.util.ArrayList;

import resep.models.Menu;
import resep.models.User;
import resep.utils.ScreenHelper;

public class MenuUser extends Menu {
    private ArrayList<User> data;

    public MenuUser(ArrayList<User> data) {
        this.data = data;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                 DATA USER                   |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil User                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah User                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Edit User                               |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus User                              |");
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

    public void tampilData() {
        ScreenHelper.clearConsole();
        if (data.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|               TAMPIL DATA USER              |");
            System.out.println("+=============================================+");
            for (User tempUser : data) {
                System.out.println("Nama User     : " + tempUser.getNama());
                System.out.println("Email         : " + tempUser.getEmail());
                System.out.println("Username      : " + tempUser.getUsername());
                System.out.println("Password      : " + tempUser.getPassword());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data User kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    public void tambah() {
        ScreenHelper.clearConsole();
        String nama, email, username, password;
        System.out.println("+=============================================+");
        System.out.println("|              TAMBAH DATA USER               |");
        System.out.println("+=============================================+");

        System.out.print("Nama User      : ");
        nama = input.nextLine();
        System.out.print("Email          : ");
        email = input.nextLine();
        System.out.print("Username       : ");
        username = input.nextLine();
        System.out.print("Password       : ");
        password = input.nextLine();

        User tempUser = new User(
                nama, email, username, password);
        data.add(tempUser);
        System.out.println("+=============================================+");
        System.out.println("|             DATA USER TERSIMPAN             |");
        System.out.println("+=============================================+");
        input.nextLine();
    }

    public void edit() {
        int indexUser = pilih();
        if (indexUser != -1) {
            User editUser = data.get(indexUser);
            System.out.println("+=============================================+");
            System.out.println("|               EDIT DATA USER                |");
            System.out.println("+=============================================+");
            System.out.print("Nama User     : ");
            editUser.setNama(input.nextLine());
            System.out.print("Email         : ");
            editUser.setEmail(input.nextLine());
            System.out.print("Username      : ");
            editUser.setUsername(input.nextLine());
            System.out.print("Password      : ");
            editUser.setPassword(input.nextLine());
            data.set(indexUser, editUser);
            System.out.println("+=============================================+");
            System.out.println("|             DATA USER TERSIMPAN             |");
            System.out.println("+=============================================+");
            input.nextLine();
            input.nextLine();
        }
    }

    public void hapus() {
        int indexUser = pilih();
        if (indexUser != -1) {
            data.remove(indexUser);
            System.out.println("+=============================================+");
            System.out.println("|              DATA USER DIHAPUS              |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public int pilih() {
        ScreenHelper.clearConsole();
        String username = "";
        int userDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                 PILIH USER                  |");
                System.out.println("+=============================================+");
                for (User tempUser : data) {
                    System.out.println("Nama User      : " + tempUser.getNama());
                    System.out.println("Email          : " + tempUser.getEmail());
                    System.out.println("Username       : " + tempUser.getUsername());
                    System.out.println("Password       : " + tempUser.getPassword());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih username user : ");
                username = input.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getUsername().equals(username)) {
                        userDipilih = i;
                        break;
                    }
                }
            } while (userDipilih == -1);
        } else {
            System.out.println("Data User kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return userDipilih;
    }
}
