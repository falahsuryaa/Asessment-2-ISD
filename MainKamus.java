import java.util.Scanner;

public class MainKamus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kamus kamus = new Kamus();
        int pilihan;

        do {
            System.out.println("\n=== Menu Kamus ===");
            System.out.println("1. Tambah kosakata");
            System.out.println("2. Cari kosakata");
            System.out.println("3. Tampilkan seluruh kosakata");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt(); sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kata baru: ");
                    String kata = sc.nextLine();
                    kamus.tambahKata(kata);
                    System.out.println("Kata berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan kata yang ingin dicari: ");
                    String cari = sc.nextLine();
                    if (kamus.cariKata(cari)) {
                        System.out.println("Kata \"" + cari + "\" ditemukan.");
                    } else {
                        System.out.println("Kata \"" + cari + "\" tidak ditemukan.");
                    }
                    break;
                case 3:
                    kamus.tampilkanKamus();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}

