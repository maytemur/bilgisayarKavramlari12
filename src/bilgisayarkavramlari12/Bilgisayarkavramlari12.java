/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bilgisayarkavramlari12;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author maytemur Lambda Calculus ve Fonksiyonel Programlama (10 ve 11 nci
 * video) LambdaCalculus1.png 1'nci resim - tarihsel gelişimi vs
 * LambdaCalculus2.png - kullanım şekli Lambda Expression'a bir örnek yapalım
 * LambdaCalculus3.png - tanımlama ve kullanım şekli
 */
public class Bilgisayarkavramlari12 {

    // ilk yapmamız gereken şey 1 tane interface tanımlamak
    interface lambda {

        //tanımlıyacağımız fonksiyonun tipini belirtmemiz gerekiyor bu sadece 
        //Javaya özgü bir şey Lisp'de vs tipini belirtmenize gerek yok dedi
        int calistir(int x);
    }

    interface lambda2 {

        int calistir2(int x, int y);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        lambda c = (int x) -> x * x;
        //tek satır olunca paranteze gerek yok en sade şu haldede yazabiliriz
        lambda kup = x -> x * x * x;

        lambda2 d = (x, y) -> x * y;
        System.out.println(c.calistir(4));
        System.out.println(kup.calistir(4));
        System.out.println(d.calistir2(4, 6));

        //Fonksiyonel programlamadan bahsediyoruz.Lisp ve Scala fonksiyonel bir dildir. Scala 
        //özellikle bigdata olaylarında kullanıyor. Ayrıca en çok stream olaylarında kullanıyoruz
        //örnek verelim
        List<Integer> intSeq = Arrays.asList(1, 2, 3, 4);

        intSeq.forEach(x -> System.out.println(x));
        //2nci bir kullanım yapalım
        intSeq.forEach(x -> {
            x += 2;
            int y = x + 2;
            System.out.println("y nin değeri: " + y);
        });
        //3ncü bir kullanım özelikle data işlemlerinde çok kullanılıyormuş, map-reduce şekli
        //bütün elemanların üzerinde map uygulanır ondan sonra  ise reduce uygulanır
        // paralel programlamanın, big data dünyasının temel yapısıdır
        //hadoop üzerinde bir wordcounter uygulamamız örneğimiz var dedi
        int toplama = intSeq.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
        System.out.println("toplama değeri: " + toplama);
    }
    //ayrıca video'da https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
    //adresindeki örnek incelendi daha sonra bakılabilir ,örneğin sitelerde 
    //advanced search yapılacağı zaman artık bu şekilde kullanılıyor dedi
}
