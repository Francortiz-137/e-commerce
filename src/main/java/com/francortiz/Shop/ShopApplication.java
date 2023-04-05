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
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderItemRepository orderItemRepository;

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

		User u1 = new User("Franco","Ortiz","francortiz@example.com","password","","+123456789", LocalDateTime.now(), LocalDateTime.now());
		User u2 = new User("John","Doe","johndoe@example.com","password","","+123456798", LocalDateTime.now(), LocalDateTime.now());

		userRepository.save(u1);
		userRepository.save(u2);

		Role r1 = new Role("ADMIN");
		Role r2 = new Role("USER");
		roleRepository.save(r1);
		roleRepository.save(r2);

		u1.setRoles(List.of(r1,r2));
		u2.setRoles(List.of(r2));

		userRepository.save(u1);
		userRepository.save(u2);

		Cart c1 = new Cart();
		Cart c2 = new Cart();
		cartRepository.save(c1);
		cartRepository.save(c2);

		Order o1 = new Order();
		Order o2 = new Order();
		Order o3 = new Order();
		Order o4 = new Order();
		Order o5 = new Order();

		orderRepository.save(o1);
		orderRepository.save(o2);
		orderRepository.save(o3);
		orderRepository.save(o4);
		orderRepository.save(o5);

		c1.setUser(u1);
		o1.setUser(u1);
		o2.setUser(u1);
		o3.setUser(u1);
		o4.setUser(u1);
		o5.setUser(u1);
		u1.setCart(c1);
		u1.setOrders(List.of(o1,o2,o3,o4,o5));
		cartRepository.save(c1);
		userRepository.save(u1);

		c2.setUser(u2);
		u2.setCart(c2);
		cartRepository.save(c2);
		userRepository.save(u2);


		CartItem cI1 = new CartItem();
		CartItem cI2 = new CartItem();
		cI1.setAmount(2);
		cI2.setAmount(1);
		cartItemRepository.save(cI1);
		cartItemRepository.save(cI2);

		OrderItem oI1 =new OrderItem();
		OrderItem oI2 =new OrderItem();
		OrderItem oI3 =new OrderItem();
		OrderItem oI4 =new OrderItem();
		OrderItem oI5 =new OrderItem();
		OrderItem oI6 =new OrderItem();
		OrderItem oI7 =new OrderItem();
		OrderItem oI8 =new OrderItem();
		OrderItem oI9 =new OrderItem();
		OrderItem oI10 =new OrderItem();
		oI1.setAmount(1);
		oI2.setAmount(1);
		oI3.setAmount(1);
		oI4.setAmount(1);
		oI5.setAmount(1);
		oI6.setAmount(1);
		oI7.setAmount(1);
		oI8.setAmount(1);
		oI9.setAmount(1);
		oI10.setAmount(1);

		cI1.setProduct(p1);
		cI2.setProduct(p2);
		cartItemRepository.save(cI1);

		oI1.setProduct(p1);
		oI2.setProduct(p2);
		oI3.setProduct(p3);
		oI4.setProduct(p4);
		oI5.setProduct(p5);
		oI6.setProduct(p6);
		oI7.setProduct(p7);
		oI8.setProduct(p8);
		oI9.setProduct(p9);
		oI10.setProduct(p10);
		orderItemRepository.save(oI1);
		orderItemRepository.save(oI2);
		orderItemRepository.save(oI3);
		orderItemRepository.save(oI4);
		orderItemRepository.save(oI5);
		orderItemRepository.save(oI6);
		orderItemRepository.save(oI7);
		orderItemRepository.save(oI8);
		orderItemRepository.save(oI9);
		orderItemRepository.save(oI10);

		c1.addCartItems(cI1);
		c1.addCartItems(cI2);
		cartRepository.save(c1);

		o1.addOrderItems(oI1);
		o1.addOrderItems(oI2);
		o1.addOrderItems(oI3);
		o1.addOrderItems(oI4);
		o1.addOrderItems(oI5);
		o2.addOrderItems(oI6);
		o3.addOrderItems(oI7);
		o4.addOrderItems(oI8);
		o5.addOrderItems(oI9);
		o5.addOrderItems(oI10);
		orderRepository.save(o1);
		orderRepository.save(o2);
		orderRepository.save(o3);
		orderRepository.save(o4);
		orderRepository.save(o5);
	}
}
