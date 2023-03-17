import java.util.ArrayList;
import java.util.Scanner;

public class Transaksi {
    ArrayList<Integer> idMember = new ArrayList<Integer>();
    ArrayList<Integer> idBarang = new ArrayList<Integer>();
    ArrayList<Integer> banyak = new ArrayList<Integer>();

    public void setTransaksi(Barang barang, int idMember, int idBarang, int banyak){
        this.idMember.add(idMember);
        this.idBarang.add(idBarang);
        this.banyak.add(banyak);
        barang.editStok(idBarang, barang.getStok(idBarang)-banyak);
    }

    public int prosesTransaksi(Member member, Transaksi transaksi, Barang barang){
        Scanner sc = new Scanner(System.in);

        System.out.println("----------Golden Florist----------");
        System.out.print("Masukkan ID Member: ");
        int idMember = sc.nextInt();
        System.out.println("Selamat Datang "+member.getNama(idMember));
        System.out.println("Silahkan Berbelanja");

        ArrayList<Integer> idBarang = new ArrayList<Integer>();
        ArrayList<Integer> banyak = new ArrayList<Integer>();
        int i = 0;
        Laporan laporan = new Laporan();
        laporan.laporan(barang);
        System.out.print("Masukkan kode barang: ");
        int kodeBarang = sc.nextInt();
        idBarang.add(kodeBarang);
        System.out.print(barang.getNamaBarang(idBarang.get(i))+" sebanyak: ");
        banyak.add(sc.nextInt());

        int y = idBarang.size();
        for (int l = 0; l < y; l++){
            if (barang.getStok(idBarang.get(l)) < banyak.get(l)){
                System.out.println("Maaf stok tidak memenuhi.");
                System.exit(0);
            }
        }

        int total = 0;
        int x = idBarang.size();
        for (int j = 0; j < x; j++) {
            int jumlah = banyak.get(j) * barang.getHarga(idBarang.get(j));
            total += jumlah;
            if (member.getSaldo(idMember) < jumlah) {
                System.out.println("Maaf Saldo Anda kurang.");
                System.out.print("1. Edit Saldo\n2. Hentikan Transaksi\n= ");
                int saldo = sc.nextInt();
                switch (saldo){
                    case 1:
                        System.out.print("Masukkan saldo baru: ");
                        int newSaldo = sc.nextInt();
                        member.editSaldo(idMember, newSaldo);
                        laporan.laporan(member);
                        break;
                    case 2:
                    break;
                }
            } else {
                System.out.println("----------Golden Florist----------");
                System.out.println("Transaksi belanja "+member.getNama(idMember)+" sebagai berikut: ");
                System.out.println("Nama Barang\tQty\tSatuan\tHarga");
                System.out.println(barang.getNamaBarang(idBarang.get(j)) + "\t" + banyak.get(j) + "\t" + barang.getHarga(idBarang.get(j)) + "\t" + jumlah);
                transaksi.setTransaksi(barang, idMember, idBarang.get(j), banyak.get(j));
                System.out.println("----------------------------------");
                System.out.println("Total: " + jumlah);
                System.out.println("Saldo: " + member.getSaldo(idMember));
                int sisaSaldo = member.getSaldo(idMember) - jumlah;
                member.editSaldo(idMember, sisaSaldo);
                System.out.println("Sisa Saldo: " + member.getSaldo(idMember));
                System.out.println("----------------------------------");
                System.out.println("Terimakasih sudah berbelanja!");
            }
        }

        return 0;
    }

    public int getIdBarang(int id){
        return this.idBarang.get(id);
    }

    public int getBanyak (int id){
        return this.banyak.get(id);
    }

    public int getIdMember(int id){
        return this.idMember.get(id);
    }

    public int getJmlTransaksi(){
        return this.idMember.size();
    }

}
