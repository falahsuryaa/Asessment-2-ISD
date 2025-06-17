import java.util.PriorityQueue;

class Cucian implements Comparable<Cucian> {
    int idCuci;
    String namaPelanggan;
    int tanggalMasuk;
    String tipe;
    int berat;

    public Cucian(int idCuci, String namaPelanggan, int tanggalMasuk, String tipe, int berat) {
        this.idCuci = idCuci;
        this.namaPelanggan = namaPelanggan;
        this.tanggalMasuk = tanggalMasuk;
        this.tipe = tipe.toLowerCase();
        this.berat = berat;
    }

    private int getLamaPengerjaan() {
        switch (tipe) {
            case "kilat": return 1;
            case "express": return 2;
            case "biasa": return 3;
            default: return Integer.MAX_VALUE;
        }
    }

    @Override
    public int compareTo(Cucian o) {
        int lama1 = this.getLamaPengerjaan();
        int lama2 = o.getLamaPengerjaan();

        if (lama1 != lama2) {
            return Integer.compare(lama1, lama2);
        } else {
            return Integer.compare(this.tanggalMasuk, o.tanggalMasuk);
        }
    }

    @Override
    public String toString() {
        return "idCuci = " + idCuci + ", namaPelanggan = " + namaPelanggan;
    }
}

class DaftarCuci {
    PriorityQueue<Cucian> antreanCuci = new PriorityQueue<>();

    public void terimaCucian(int id, String nama, int tanggal, String tipe, int berat) {
        Cucian c = new Cucian(id, nama, tanggal, tipe, berat);
        antreanCuci.add(c);
    }

    public void tampilkanUrutan() {
        System.out.println("Urutan cucian harus diselesaikan:");
        while (!antreanCuci.isEmpty()) {
            System.out.println(antreanCuci.poll());
        }
    }
}


