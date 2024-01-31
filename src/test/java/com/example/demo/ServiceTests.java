package com.example.demo;

import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import com.example.demo.service.CadeauService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTests {

	@Autowired
	CadeauService cadeauService;

	@Test
	void testService() {
		cadeauService.findAll().forEach( c-> System.out.println(c.getNom()));
	}

	@Test
	void testOneToMany(){
		cadeauService.afficheLesCadeauxDeLaListe();
	}

}
