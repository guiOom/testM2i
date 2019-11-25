package com.barbet.gauthier.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.barbet.gauthier.exception.UpdateException;
import com.barbet.gauthier.models.Salle;
import com.barbet.gauthier.models.T;
import com.barbet.gauthier.services.SalleService;

public class Main {

	public static void main(String[] args) throws UpdateException {

		// Initialisation
		SalleService ss = new SalleService();
		
		// Création de 5 sales
		for (int i = 0; i < 10; i++)
			ss.getT().add(new Salle("code"+i,"libelle"+i));
		
		// Affichage
		for (T s : ss.getT())
			Display.display(s);
		
		// Suppression de la salle 1
		ss.delete(ss.getT().get(1));
		Display.lineJump();
		for (T s : ss.getT())
			Display.display(s);
		
		// Modifier une salle (erreur)
		// ?
		Display.display("\n   update");
		try {
			ss.update(ss.getT().get(2), 5);
		} catch (UpdateException e) {
			Display.display(e.getMessage());
		}

		// Modifier une salle (ok)
		try {
			ss.update(ss.getT().get(2), 3); //ok cloned 
		} catch (UpdateException e) {
			Display.display(e.getMessage());
		}
		
		// Affichage
		for (T s : ss.getT())
			Display.display(s);

		
		//////////////////////////////////////////////////////
		// Dev fonctionnel
		Display.display("\n   dev fonctionnel (avec Stream)");

		List<Salle> list = new ArrayList<Salle>();
		
		// Création de 10 salles
		for (int i = 0; i < 10; i++)
			list.add(new Salle("code"+i,"libelle"+i));
		
		/*
		list.stream()
		.filter(x -> x.getId()== 3)
		.map(x -> x.getId()==3)
		.sorted()
		.forEach(System.out::println);
		
		list.forEach(System.out::println);
		*/
		Stream<Salle> stream = list.stream();
		stream.forEach(System.out::println); 
		// on ne peut en faire 2 à la fois
		// le premier stream est entièrement consommé
		System.out.println();
		Stream<Salle> stream2 = list.stream();
		stream2.filter( x -> x.getId()>15) // trie le stream
		.map(x -> x.getId()) // enlève les autres informations
		.forEach(System.out::println);
		
		System.out.println("ex somme");
		Stream<Salle> stream3 = list.stream();
		Integer somme = stream3.filter(x -> x.getId()>15)
				.map(x -> x.getId())
				.reduce(0, (x,y) -> (x+y))/4;
				//.reduce(0, (x,y) -> x+y);
		System.out.println(somme);
		
		// Optional
		Stream<Salle> stream4 = list.stream();
		Optional <Integer> somme2 = stream4.filter(x -> x.getId()>100)
				.map(x -> x.getId())
				.reduce((x,y) -> (x+y));
				//.reduce(0, (x,y) -> x+y);
		if(somme2.isPresent())
			System.out.println(somme2);
		else
			System.out.println("pas d'id");
		
		////////////////////////////////////////////////////////

		Stream<Salle> stream5 = list.parallelStream();
		stream5.forEach(System.out::println);
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
		
	}

}
