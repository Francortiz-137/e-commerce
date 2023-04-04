package com.francortiz.Shop;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.models.*;
import com.francortiz.Shop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartItemRepository cartItemRepository;

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product("Television Samsung", Type.ELECTRONICOS,"Television 60\" UHD", 1000000.0,"tele_samsung_01", LocalDateTime.now());
		Product p2 = new Product("Zapatillas",Type.ZAPATERIA,"zapatillas urbanas color gris", 50000.0,"zapatillas_01", LocalDateTime.now());
		Product p3 = new Product("Poleron",Type.ROPA_HOMBRE,"perfecto para cualquier ocacion", 35000.0,"ropa_hombre_01", LocalDateTime.now());
		Product p4 = new Product("Celular",Type.ELECTRONICOS,"lleva tu creatividad a todos lados con el nuevo iphone", 1200000.0,"smartphone_01", LocalDateTime.now());
		Product p5 = new Product("Saco de Boxeo",Type.DEPORTES,"saca todo tu poder frente al mas resistente de los sacos", 30000.0,"box_01", LocalDateTime.now());
		Product p6 = new Product("Chaqueta Mujer",Type.ROPA_MUJER,"chaqueta impermeable perfecta para las lluvias", 130000.0,"woman_01", LocalDateTime.now());
		Product p7 = new Product("Pantalon niño",Type.ROPA_NINO,"pantalon color caqui", 3000.0,"kid_01", LocalDateTime.now());
		Product p8 = new Product("Cama King Size",Type.HOGAR,"Cama para un rey como tu", 1500000.0,"bed_01", LocalDateTime.now());
		Product p9 = new Product("Comedor",Type.HOGAR,"comedor con 6 sillas", 400000.0,"dinning_01", LocalDateTime.now());
		Product p10 = new Product("Max Steel",Type.JUGETERIA,"muneco de accion articulable", 12000.0,"toy_01", LocalDateTime.now());


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

		User u1 = new User("John","Doe","johndoe@example.com","password","","+123456789", LocalDateTime.now(), LocalDateTime.now());
		userRepository.save(u1);

		Role r1 = new Role("ADMIN");
		Role r2 = new Role("USER");
		roleRepository.save(r1);
		roleRepository.save(r2);

		u1.setRoles(List.of(r1));
		userRepository.save(u1);

		Cart c1 = new Cart();
		cartRepository.save(c1);


		c1.setUser(u1);
		u1.setCart(c1);
		cartRepository.save(c1);
		userRepository.save(u1);

		CartItem cI1 = new CartItem();
		cI1.setAmount(2);
		cartItemRepository.save(cI1);

		cI1.setProduct(p1);
		cartItemRepository.save(cI1);

		c1.addCartItems(cI1);
		cartRepository.save(c1);


	}
}
