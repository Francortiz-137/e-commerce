package com.francortiz.Shop;

import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product("Television Samsung","electronicos","Television 60\" UHD", 1000000.0,"tele_samsung_01");
		Product p2 = new Product("Zapatillas","Calzado","zapatillas urbanas color gris", 50000.0,"zapatillas_01");
		Product p3 = new Product("Poleron","Ropa Hombre","perfecto para cualquier ocacion", 35000.0,"ropa_hombre_01");
		Product p4 = new Product("Celular","electronicos","lleva tu creatividad a todos lados con el nuevo iphone", 1200000.0,"smartphone_01");
		Product p5 = new Product("Saco de Boxeo","Deportes","saca todo tu poder frente al mas resistente de los sacos", 30000.0,"box_01");
		Product p6 = new Product("Chaqueta Mujer","Ropa mujer","chaqueta impermeable perfecta para las lluvias", 130000.0,"woman_01");
		Product p7 = new Product("Pantalon niño","Ropa niño","pantalon color caqui", 3000.0,"kid_01");
		Product p8 = new Product("Cama King Size","Muebles y hogar","Cama para un rey como tu", 1500000.0,"bed_01");
		Product p9 = new Product("Comedor","Muebles y hogar","comedor con 6 sillas", 400000.0,"dinning_01");
		Product p10 = new Product("Max Steel","electronicos","muneco de accion articulable", 12000.0,"toy_01");


		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p3);
		productRepository.save(p4);
		productRepository.save(p5);
		productRepository.save(p6);
		productRepository.save(p7);
		productRepository.save(p8);
		productRepository.save(p9);
		productRepository.save(p10);
	}
}
