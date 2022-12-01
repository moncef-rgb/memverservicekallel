package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.services.IMemberService;

@SpringBootApplication
public class MemberServiceApplication implements CommandLineRunner{
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	IMemberService memberService;

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Etudiant etd1 = new Etudiant();
		
		etd1.setNom("moncef");
		etd1.setCin("12345678");
		etd1.setPrenom("boukhris");
		etd1.setDate(new Date());
		memberRepository.save(etd1);
		
		Etudiant etd2 = new Etudiant();
		
		etd2.setNom("mondher");
		etd2.setCin("12345679");
		etd2.setPrenom("boukhris");
		etd2.setDate(new Date());
		memberRepository.save(etd2);
		
		EnseignantChercheur ens1= new EnseignantChercheur();
		
		ens1.setNom("mariem");
		ens1.setCin("12345677");
		ens1.setPrenom("boukhris");
		ens1.setDate(new Date());
		memberRepository.save(ens1);
		
		EnseignantChercheur ens2= new EnseignantChercheur();
		
		ens2.setNom("amina");
		ens2.setCin("12345676");
		ens2.setPrenom("boukhris");
		ens2.setDate(new Date());
		memberRepository.save(ens2);
		
		
		List<Member> mbrs = memberRepository.findAll();
		for (Member member : mbrs) {
			System.out.println(member.getNom() + " "+member.getPrenom());
		}
		
		System.out.println("++++++++++++++++++++");
		
		Member m1 = memberRepository.findById(1L).get();
		System.out.println(m1.getNom());
		
		System.out.println("++++++++++++++++++++");
		
		memberRepository.delete(etd2);
		etd1.setDiplome("info");
		memberRepository.save(etd1);
		
		Member m = memberService.findMember(1L);
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
		memberService.deleteMember(3L);
	}

}
