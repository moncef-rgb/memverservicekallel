package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.repository.EnseignantChercheurRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberImpl implements IMemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	
	@Override
	public Member addMember(Member m) {
		memberRepository.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {

		memberRepository.deleteById(id);
	}

	@Override
	public Member updateMember(Member m) {
		
		return memberRepository.saveAndFlush(m);
	}

	@Override
	public Member findMember(Long id) {
		Member m =(Member)memberRepository.findById(id).get();
		return m;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	@Override
	public Member findByCin(String cin) {
		// TODO Auto-generated method stub
		return memberRepository.findByCin(cin);
	}

	@Override
	public Member findByEmail(String email) {
		// TODO Auto-generated method stub
		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Member> findByNom(String nom) {
		// TODO Auto-generated method stub
		return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		// TODO Auto-generated method stub
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		// TODO Auto-generated method stub
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

}
