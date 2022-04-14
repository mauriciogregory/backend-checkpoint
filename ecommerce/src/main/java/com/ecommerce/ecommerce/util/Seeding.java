package com.ecommerce.ecommerce.util;

import com.ecommerce.ecommerce.repository.CategoriesRepository;
import com.ecommerce.ecommerce.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Seeding implements ApplicationRunner {

    private ProductsRepository productsRepository;
    private CategoriesRepository categoriesRepository;

    @Autowired
    public Seeding(ProductsRepository productsRepository, CategoriesRepository categoriesRepository){
        this.productsRepository = productsRepository;
        this.categoriesRepository =categoriesRepository;
    }

    public void run(ApplicationArguments args){
//        Categories cat1 = new Categories("Percussão");
//        Categories cat2 = new Categories("Sopro");
//        Categories cat3 = new Categories("Corda");
//        Categories cat4 = new Categories("Teclas");
//
//        categoriesRepository.save(cat1);
//        categoriesRepository.save(cat2);
//        categoriesRepository.save(cat3);
//        categoriesRepository.save(cat4);
//
//        Products prod = new Products("Bateria Acústica Premium DX722 Bumbo 22","Bateria com pratos de alta tecnologia, para iniciantes.", 2000.0, "https://http2.mlstatic.com/D_NQ_NP_899447-MLB31767940279_082019-O.jpg", cat1);
//        Products prod1 = new Products("Flauta","Instrumento de ótima qualidade", 80.00, "https://m.media-amazon.com/images/I/51dDUd9e8fL._AC_SY450_.jpg", cat2);
//        Products prod2 = new Products("Violão", "GIANNINI N-14Bk Violão Acústico Preto", 312.21, "https://m.media-amazon.com/images/I/419CgWR0hkL._AC_.jpg" , cat3);
//        Products prod3 = new Products("Bateria", "Bateria Acústica 2 Tons ESL Prata NY F1rst", 2.289, "https://m.media-amazon.com/images/I/61opBmhlcqL._AC_SX679_.jpg"
//        , cat1);
//        Products prod4 = new Products("Clarinete", "Baquelite 17 Chave B ♭ Chapeamento de Níquel Soprano", 589.00, "https://m.media-amazon.com/images/I/21taTbkiPOL._AC_US40_.jpg"
//        , cat2);
//        Products prod5 = new Products("Ukulele", "Ukulele Soprano", 378.00, "https://m.media-amazon.com/images/I/61LhvZallaL._AC_SX679_.jpg", cat3);
//        Products prod6 = new Products("Piano", "Piano Digital Alesis Virtue 88 teclas com pedais, suporte e banco ajustável", 5.100, "https://m.media-amazon.com/images/I/61lbv4V2lPS._AC_SX679_.jpg"
//        ,cat4);
//        Products prod7 = new Products("Teclado", "TECLADO PIANO MUSICAL ELETRÔNICO YAMAHA PSS-F30", 533.83, "https://m.media-amazon.com/images/I/61OBGRe1dWS._AC_SX679_.jpg"
//        , cat4);
//        Products prod8 = new Products("Cavaco", "CAVACO ROZINI ESTUDANTE ELETRICO NATURAL RC09ELN", 699.00, "https://m.media-amazon.com/images/I/51OT7lXN50L._AC_SX679_.jpg"
//        , cat3);
//        Products prod9 = new Products("Flauta", "Flauta Doce Soprano Barroca C, Yamaha, YRS-24B", 56.75, "https://m.media-amazon.com/images/I/51dDUd9e8fL._AC_SY450_.jpg"
//        , cat2);
//        Products prod10 = new Products("Reco-Reco", "Reco Reco Spanking 02 molas Alumínio", 68.99, "https://m.media-amazon.com/images/I/61EB151tMnL._AC_SX679_.jpg"
//        , cat1);
//        Products prod11 = new Products("Pandeiro", "PANDEIRO CONTEMPORANEA LIGHT 82LT 10 POL MADEIRA NYLON", 166.00, "https://m.media-amazon.com/images/I/51lgbtiqbYS._AC_SX679_.jpg"
//        , cat1);
//        Products prod12 = new Products("Violão", "Violão Acústico Clássico Nylon C40MII Natural YAMAHA, Yamaha, C40MII", 859.00, "https://m.media-amazon.com/images/I/61dtUAwnZqL._AC_SX679_.jpg"
//        , cat3);
//        Products prod13 = new Products("Violino", "Violino Vivace Mozart Mo44 4/4 Com Case Luxo", 457.00, "https://m.media-amazon.com/images/I/81dh+FvQUKL._AC_SX679_.jpg"
//        , cat3);
//
//
//        productsRepository.save(prod);
//        productsRepository.save(prod1);
//        productsRepository.save(prod2);
//        productsRepository.save(prod3);
//        productsRepository.save(prod4);
//        productsRepository.save(prod5);
//        productsRepository.save(prod6);
//        productsRepository.save(prod7);
//        productsRepository.save(prod8);
//        productsRepository.save(prod9);
//        productsRepository.save(prod10);
//        productsRepository.save(prod11);
//        productsRepository.save(prod12);
//        productsRepository.save(prod13);
    }

}