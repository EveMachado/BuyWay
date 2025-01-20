package com.gestaoseries.poo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gestaoseries.poo.entities.Category;
import com.gestaoseries.poo.entities.Order;
import com.gestaoseries.poo.entities.User;
import com.gestaoseries.poo.entities.enums.OrderStatus;
import com.gestaoseries.poo.repositories.CategoryRepository;
import com.gestaoseries.poo.repositories.OrderRepository;
import com.gestaoseries.poo.repositories.UserRepository;

//para falar para o spring que essa é uma classe especifica de configuração
@Configuration

//para falar que essa classe ela vai ser uma configuração especifica para o perfil de teste
@Profile("test")

//
public class TestConfig implements CommandLineRunner{

	//para que o spring consiga resolver essa dependencia e a associar uma instancia do UserReposity no meu TestConfig
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	//tudo que colocar dentro desse metodo vai ser executado quando a aplicação for iniciada
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null,Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);

		
		//salvando os usuarios no banco de dados
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
	
	
	
}
