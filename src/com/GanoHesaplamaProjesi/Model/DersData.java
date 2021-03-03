package com.GanoHesaplamaProjesi.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;

public class DersData {
    private static DersData instance=new DersData();

    private DersData(){
    }

    public static DersData getInstance(){
        return instance;
    }

    private ObservableList<Ders> dersListesi;

    public ObservableList<Ders> getDersListesi() {
        return dersListesi;
    }

    public void dersiSil(Ders ders){
        dersListesi.remove(dersListesi.indexOf(ders));
    }

    public void dersEkle(Ders eklenecekDers){
        dersListesi.add(eklenecekDers);
        GanoHesapla();
    }

    public void dersleriSil(){
        dersListesi.clear();
    }

    public double GanoHesapla(){

        double toplam=0;
        double toplamEcts=0;

        for(int i=0;i<dersListesi.size();i++){
            toplam+=dersListesi.get(i).getEcts()*harfDonusumu(dersListesi.get(i).getHarf());
            toplamEcts+=dersListesi.get(i).getEcts();
        }
        return toplam/toplamEcts;

    }

    private double harfDonusumu(String harf){
        harf.toLowerCase();
        harf.trim();
        if(harf.equals("aa"))
            return 4;
        else if (harf.equals("ab")||harf.equals("ba"))
            return 3.5;
        else if(harf.equals("bb"))
            return 3;
        else if(harf.equals("cb")||harf.equals("bc"))
            return 2.5;
        else if(harf.equals("cc"))
            return 2;
        else if(harf.equals("cd")||harf.equals("dc"))
            return 1.5;
        else if(harf.equals("dd"))
            return 1;
        else if (harf.equals("fd")||harf.equals("df"))
            return 0.5;
        else
            return 0;
    }

    public void DersleriDosyadanGetir(){

        dersListesi= FXCollections.observableArrayList();
        //Ders adı /t Harf /t ECTS
        try (BufferedReader okuyucu = new BufferedReader(new FileReader("Dersler.txt"))) {

            String okunanSatir;

            while ((okunanSatir=okuyucu.readLine())!=null){
                String[] parcalaraBol=okunanSatir.split("\t");
                String ad=parcalaraBol[0];
                String harf=parcalaraBol[1];
                String ects=parcalaraBol[2];

                Ders ders=new Ders(ad,harf,Integer.parseInt(ects));

                dersListesi.add(ders);

            }
                System.out.println("Getirilen harfler:"+dersListesi.get(0).getHarf());
        } catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadı");
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası");
        }




    }

    public void DersleridosyayaYaz(){

        try (BufferedWriter yazici = new BufferedWriter(new FileWriter("Dersler.txt"))) {

            Iterator<Ders> iter=dersListesi.iterator();
            while (iter.hasNext()){
                Ders oankiDers= iter.next();

                yazici.write(oankiDers.getAd()+"\t"+oankiDers.getHarf()+"\t"+String.valueOf(oankiDers.getEcts()));
                yazici.newLine();

            }
        } catch (IOException e) {
            System.out.println("Yazıcı hatası");
        }

    }

}
