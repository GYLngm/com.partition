package com.partition;

import java.util.Arrays;
import java.util.List;

import com.partition.*;

public class Client {
	public static void main(String[] args) {
		
		if(args.length != 0) {
			System.out.println(Partition.doTerminalCMD(args));
		} else {
			
			// instantialiser Partition Object.
			Partition helper = new Partition();
			
			// creer une liste a traitee.
			List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
			
			
			// appeller le methode <<partition>>, entrer liste comme premier parametre, taille le deuxiem.
			List<List<Integer>> list2PartSet = helper.partition(liste, 2);// expecter {{1,2},{3,4},{5}}
			List<List<Integer>> list3PartSet = helper.partition(liste, 3);// expecter {{1,2,3},{4,5}}
			List<List<Integer>> list1PartSet = helper.partition(liste, 1);// expecter {{1},{2},{3},{4},{5}}
			
			// les resultats
			System.out.println(Partition.displayString(list2PartSet)+", length: "+list2PartSet.size());
			System.out.println(Partition.displayString(list3PartSet)+", length: "+list3PartSet.size());
			System.out.println(Partition.displayString(list1PartSet)+", length: "+list1PartSet.size());
			
			
		}
		
	}
}
