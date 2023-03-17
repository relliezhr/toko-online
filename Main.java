import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Member member = new Member();
    public static Karyawan karyawan = new Karyawan();
    public static Barang barang = new Barang();
    public static Transaksi transaksi = new Transaksi();
    public static Laporan laporan = new Laporan();

    public static void main(String[] args) {

        String loop = "Y";
        while (loop.equalsIgnoreCase("Y") && loop.equalsIgnoreCase("y")) {
            //Login awal
            System.out.print("Login sebagai (Member/Karyawan): ");
            String login = sc.next();

            //Login sebagai member
            if (login.equalsIgnoreCase("Member")) {
                laporan.laporan(member);

                System.out.print("Apakah kamu terdaftar sebagai Member (Y/N): ");
                String idMember = sc.next();

                if (idMember.equalsIgnoreCase("Y")) {
                   runMember();

                } else if (idMember.equalsIgnoreCase("N")) {
                    System.out.println("Silahkan input data diri anda!");
                    System.out.print("Masukkan Nama: ");
                    member.setNama(sc.next());
                    System.out.print("Masukkan Alamat: ");
                    member.setAlamat(sc.next());
                    System.out.print("Masukkan Telepon: ");
                    member.setTelepon(sc.next());
                    System.out.print("Masukkan Saldo: ");
                    member.setSaldo(sc.nextInt());
                    laporan.laporan(member);
                    runMember();

                } else {
                    break;
                }

                //Login sebagai karyawan
            } else if (login.equalsIgnoreCase("Karyawan")) {
                laporan.laporan(karyawan);

                System.out.print("Apakah kamu terdaftar sebagai Karyawan (Y/N): ");
                String idKaryawan = sc.next();

                if (idKaryawan.equalsIgnoreCase("Y")) {
                    runKaryawan();

                } else if (idKaryawan.equalsIgnoreCase("N")) {
                    System.out.println("Silahkan input data diri anda!");
                    System.out.print("Masukkan Nama: ");
                    karyawan.setNama(sc.next());
                    System.out.print("Masukkan Alamat: ");
                    karyawan.setAlamat(sc.next());
                    System.out.print("Masukkan Telepon: ");
                    karyawan.setTelepon(sc.next());
                    System.out.print("Pilih Jabatan: \n1. Karyawan\n2. Boss\n3. Manager\n4. CEO\n= ");
                    karyawan.setJabatan(sc.nextInt());
                    laporan.laporan(karyawan);
                    runKaryawan();
                } else {
                    break;
                }

                //Eror
            } else {
                System.exit(0);
            }

            //Logout
            System.out.print("Login ulang (Y) atau Logout (N): ");
            loop = sc.next();
            System.out.println();

            if (loop.equalsIgnoreCase("N")) {
                System.exit(0);
            }
        }

    }

    public static void runMember(){
        String n = "Y";
        while (n.equalsIgnoreCase("Y")) {
            transaksi.prosesTransaksi(member, transaksi, barang);
            System.out.print("Lanjut Transaksi (Y/N): ");
            n = sc.next();

            if (n.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void runKaryawan(){
        System.out.println("Login sebagai Karyawan berhasil!");
        System.out.print("Masukkan ID: ");
        int newID = sc.nextInt();
        System.out.println("Selamat Datang " + karyawan.getNama(newID));
        System.out.print("Pilih data yang akan dicek: \n1. Data member\n2. Data karyawan\n3. Data Barang\n4. Data Transaksi\n= ");
        int pilih = sc.nextInt();

        switch (pilih) {
            case 1:
                laporan.laporan(member);
                System.out.print("Hapus ID Member (Y/N): ");
                String hapus = sc.next();
                if (hapus.equalsIgnoreCase("Y")) {
                    System.out.print("ID Member: ");
                    int idHapus = sc.nextInt();
                    member.removeMember(idHapus);
                    laporan.laporan(member);
                } else if (hapus.equalsIgnoreCase("N")) {
                    break;
                } else {
                    break;
                }

                break;

            case 2:
                laporan.laporan(karyawan);
                int y = karyawan.getJmlKaryawan();
                for (int l = 0; l < y; l++) {
                    if (karyawan.getStatusJabatan(newID).equals(karyawan.statusJabatan[0])) {
                        System.out.println("Maaf Anda tidak bisa menghapus ID.");
                        break;
                    } else {
                        System.out.print("Hapus ID Karyawan (Y/N): ");
                        String hapusKaryawan = sc.next();
                        if (hapusKaryawan.equalsIgnoreCase("Y")) {
                            System.out.print("ID Karyawan: ");
                            int idHapus = sc.nextInt();
                            karyawan.removeMember(idHapus);
                            laporan.laporan(karyawan);
                            break;
                        } else if (hapusKaryawan.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case 3:
                laporan.laporan(barang);
                System.out.print("1. Tambah Barang\n2. Hapus Barang\n3. Edit Stok\n= ");
                int akses = sc.nextInt();
                switch (akses) {
                    case 1:
                        System.out.println("Silahkan input data barang!");
                        System.out.print("Masukkan Nama Barang: ");
                        barang.setNamaBarang(sc.next());
                        System.out.print("Masukkan Jumlah Stok Barang: ");
                        barang.setStok(sc.nextInt());
                        System.out.print("Masukkan Harga Barang: ");
                        barang.setHarga(sc.nextInt());
                        break;
                    case 2:
                        System.out.print("ID Barang: ");
                        int idHapus = sc.nextInt();
                        barang.removeBarang(idHapus);
                        break;
                    case 3:
                        System.out.print("ID Barang: ");
                        int barangID = sc.nextInt();
                        System.out.print("Stok barang: ");
                        int stokBaru = sc.nextInt();
                        barang.editStok(barangID, stokBaru);
                        break;
                }
                laporan.laporan(barang);
                break;
            case 4:
                laporan.laporan(transaksi, barang);
                break;
        }
    }


}
