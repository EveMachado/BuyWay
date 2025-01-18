package com.gestaoseries.poo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.gestaoseries.poo.entities.User;
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

	@Override
	//tudo que colocar dentro desse metodo vai ser executado quando a aplicação for iniciada
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex", "alex@gmail.com", "977777777", "123456");

		//salvando os usuarios no banco de dados
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

	
}
