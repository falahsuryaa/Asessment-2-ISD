import java.util.*;

public class PerjalananDita {
    static Map<String, List<String>> petaKota = new HashMap<>();

    static void inisialisasiKota() {
        petaKota.put("London", Arrays.asList("Salisbury", "Birmingham", "Kingston"));
        petaKota.put("Salisbury", Arrays.asList("London", "Bristol"));
        petaKota.put("Bristol", Arrays.asList("Salisbury", "Cardiff"));
        petaKota.put("Birmingham", Arrays.asList("London", "Manchester"));
        petaKota.put("Cardiff", Arrays.asList("Bristol"));
        petaKota.put("Manchester", Arrays.asList("Birmingham", "Liverpool"));
        petaKota.put("Kingston", Arrays.asList("London"));
        petaKota.put("Liverpool", Arrays.asList("Manchester", "Newcastle"));
        petaKota.put("Newcastle", Arrays.asList("Liverpool", "Edinburgh"));
        petaKota.put("Edinburgh", Arrays.asList("Newcastle", "Glasgow"));
        petaKota.put("Glasgow", Arrays.asList("Edinburgh"));
    }

    static void bfsPerjalanan(String mulai) {
        System.out.println("Rute kunjungan kota secara berdekatan (BFS):");
        Set<String> dikunjungi = new HashSet<>();
        Queue<String> antrean = new LinkedList<>();

        antrean.add(mulai);
        dikunjungi.add(mulai);

        while (!antrean.isEmpty()) {
            String kota = antrean.poll();
            System.out.println("- " + kota);
            for (String tetangga : petaKota.getOrDefault(kota, new ArrayList<>())) {
                if (!dikunjungi.contains(tetangga)) {
                    dikunjungi.add(tetangga);
                    antrean.add(tetangga);
                }
            }
        }
    }

    static void dfsPerjalanan(String mulai) {
        System.out.println("\nRute kunjungan menyusuri kota sampai jauh (DFS):");
        Set<String> dikunjungi = new HashSet<>();
        dfsHelper(mulai, dikunjungi);
    }

    static void dfsHelper(String kota, Set<String> dikunjungi) {
        dikunjungi.add(kota);
        System.out.println("- " + kota);
        for (String tetangga : petaKota.getOrDefault(kota, new ArrayList<>())) {
            if (!dikunjungi.contains(tetangga)) {
                dfsHelper(tetangga, dikunjungi);
            }
        }
    }

    public static void main(String[] args) {
        inisialisasiKota();
        bfsPerjalanan("London");
        dfsPerjalanan("London");
    }
}
