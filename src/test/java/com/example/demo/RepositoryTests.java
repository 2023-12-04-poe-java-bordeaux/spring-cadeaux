package com.example.demo;

import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import com.example.demo.dao.ListeCadeau;
import com.example.demo.dao.ListeRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class RepositoryTests {

	@Autowired
	CadeauRepository cadeauRepository;

	@Autowired
	ListeRepository listeRepository;

	@Test
	void testSave() {
		Cadeau cadeau = new Cadeau("smartphone", "iphone", 1000.00f);
		cadeauRepository.save(cadeau);
	}

	@Test
	void testListe(){
		ListeCadeau liste = new ListeCadeau("noel");
		listeRepository.save(liste);

		Cadeau cadeau = new Cadeau("smartphone", "iphone", 1000.00f);
		cadeau.setListeCadeau(liste);
		cadeauRepository.save(cadeau);
	}


	@Test
	@Transactional
	void testOneToMany(){
		Optional<ListeCadeau> optional = listeRepository.findById(1);
		if(optional.isPresent()){
			ListeCadeau maListe = optional.get();
			System.out.println(maListe.getNom());
			maListe.getCadeaux().forEach(c-> System.out.println(c.getNom()));
		}
	}

	@Test
	@Transactional
	void testRelationBidirectionnelle(){
		Optional<ListeCadeau> optional = listeRepository.findById(1);
		if(optional.isPresent()){
			ListeCadeau maListe = optional.get();
			System.out.println(maListe);
		}
	}
}
