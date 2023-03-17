import java.util.ArrayList;

public class Member implements User{
    public ArrayList<String> namaMember = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    protected ArrayList<String> telepon = new ArrayList<String>();
    ArrayList<Integer> saldo = new ArrayList<Integer>();

    public Member (){
        //Member 1
        namaMember.add("Orel");
        alamat.add("Tuban");
        telepon.add("082140333911");
        saldo.add(1_000_000);

        //Member 2
        namaMember.add("Netta");
        alamat.add("Babat");
        telepon.add("091296335587");
        saldo.add(3_000_000);
    }

    public int removeMember(int id){
        namaMember.remove(id);
        alamat.remove(id);
        telepon.remove(id);
        saldo.remove(id);
        return 0;
    }
    public void setSaldo(int newSaldo){
        saldo.add(newSaldo);
    }

    public int getSaldo(int id){
        return saldo.get(id);
    }

    public void editSaldo(int id, int newSaldo){
        saldo.set(id, newSaldo);
    }

    public int getJmlMember(){
        return namaMember.size();
    }

    @Override
    public void setNama(String nama){
        namaMember.add(nama);
    }

    @Override
    public String getNama(int id){
        return namaMember.get(id);
    }

    @Override
    public void setAlamat(String newAlamat){
        alamat.add(newAlamat);
    }

    @Override
    public String getAlamat(int id){
        return alamat.get(id);
    }

    @Override
    public void setTelepon(String newTelepon){
        telepon.add(newTelepon);
    }

    @Override
    public String getTelepon(int id){
        return telepon.get(id);
    }



}
