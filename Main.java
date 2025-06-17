public class Main {
    public static void main(String[] args) {
        DaftarCuci daftarCuci = new DaftarCuci();

        daftarCuci.terimaCucian(1, "Intan", 3, "biasa", 5);
        daftarCuci.terimaCucian(2, "Dudi", 4, "express", 3);
        daftarCuci.terimaCucian(3, "Ruli", 4, "kilat", 1);
        daftarCuci.terimaCucian(4, "Susi", 5, "biasa", 2);
        daftarCuci.terimaCucian(5, "Ira", 6, "biasa", 5);
        daftarCuci.terimaCucian(6, "Mayang", 7, "kilat", 4);

        daftarCuci.tampilkanUrutan();
    }
} 
