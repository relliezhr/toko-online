import java.util.ArrayList;

public class Karyawan implements User{
    ArrayList<String> namaKaryawan = new ArrayList<String>();
    ArrayList<String> alamat = new ArrayList<String>();
    ArrayList<String> telepon = new ArrayList<String>();
    ArrayList<Integer> jabatan = new ArrayList<Integer>();
    String statusJabatan[] = {"Karyawan", "Boss", "Manager", "CEO"};

    public Karyawan (){

        //Karyawan 1
        namaKaryawan.add("Rellie");
        alamat.add("Tuban");
        telepon.add("083269197122");
        jabatan.add(1);

        //Karyawan 2
        namaKaryawan.add("Nabila");
        alamat.add("Babat");
        telepon.add("085769136910");
        jabatan.add(3);

    }


    public int removeMember(int id){
        namaKaryawan.remove(id);
        alamat.remove(id);
        telepon.remove(id);
        jabatan.remove(id);
        return 0;
    }
    public void setJabatan(int newJabatan){
        jabatan.add(newJabatan);
    }

    public int getJabatan(int id){
        return jabatan.get(id);
    }

    public String getStatusJabatan(int id){
        return statusJabatan[getJabatan(id)-1];
    }

    public int getJmlKaryawan(){
        return namaKaryawan.size();
    }

    @Override
    public void setNama(String nama){
        namaKaryawan.add(nama);
    }

    @Override
    public String getNama(int id) {
        return namaKaryawan.get(id);
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
