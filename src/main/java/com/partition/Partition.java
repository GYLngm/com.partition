package com.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
	
	/**
	 * Prendre une liste de chiffre et un taille de sous-liste, 
	 * retourne une liste de sous liste, où chaque sous liste a au maximum « taille » éléments
	 * Etape:
	 * 		b. creer un List<List<Integer/String/Double>> s'appelle "partitions" qui contient les sous-listes
	 * 		c. demarrer le loop de liste, dans le loop, on prendre une partie en "taille" (<=taille), et la pousser dans "partitions"
	 * 
	 * @param liste   une liste en int, ex.: Arrays.asList(1,2,3,4,5)
	 * @param taille  le taille de sous liste, ex.: 2
	 * @return une liste de sous liste avec un taille specifier
	 * 
	 * */
	public static<T> List<List<T>> partition(List<T> liste, int taille) {
		
		// creer un List<List<T>> s'appelle "partitions" qui contient les sous-listes
		List<List<T>> partitions = new ArrayList<List<T>>();
		
		//demarrer le loop de liste,
		for(int i=0;i<liste.size();i+=taille) {
			partitions.add(
					liste.subList(i, Math.min(i+taille, liste.size())) //  prendre une partie en "taille" (<=taille)
					); //la pousser dans "partitions"
			
		}
		
		return partitions;
	}
	
	
	/**
	 * -- POUR LE TEST --
	 * Convertir le List<List<T>> a un tableau Object[][].
	 * 
	 * @param liste  un List<List<T>>
	 * @return une liste de sous liste avec un taille specifier, ex.: {{1,2},{3,4},{5}}
	 * 
	 * */
	public static<T> Object[][] convertToArr(List<List<T>> source){
		
		Object[][] res = new Object[source.size()][];
		
		for(List<T> obj:source) {
			res[source.indexOf(obj)] = new Object[obj.size()];
			for(int i = 0;i<obj.size();i++) {
				res[source.indexOf(obj)][i] = obj.get(i);
			}
		}
		
		return res;
		
	}	
	
	
	
	/*
	 * Si on demarrer le programme en Terminal, appellez cette methode
	 * 
	 * */
	public static String doTerminalCMD(String[] args) {
		// instantialiser Partition Object
				Partition helper = new Partition();
				int taille = 0;
				Object source[] = null;
				boolean isAllNumeric = false;
				
				for(int i=0;i<2;i++) {
					if(args[i].length() == 1) 
						taille = Integer.parseInt(args[i]);
					else {
						if(args[i].chars().allMatch(x -> Character.isDigit(x))) { 
							isAllNumeric = true;
						}
						source = args[i].split(",");
					}
				}
				
				List<Object> liste = new ArrayList<Object>();
				if(!isAllNumeric) {
					liste = Arrays.asList(source);
				} else {
					for(int i=0;i<source.length;i++) {
						liste.add(Integer.parseInt((String) source[i]));
					}
				}
					
				List<List<Object>> partitions = partition(liste, taille);
				
				String result = displayString(partitions);
				
				return result;
	}
	
	/*
	 * @param partitions  une liste deja partitionizer
	 * @return un string comme: [[1,2],[3,4],[5]]
	 * */
	public static <T> String displayString(List<List<T>> partitions) {
		
		String result = "[";
		for(List<T> obj: partitions) {
			result += "[";
			for(T subobj:obj) {
				result += subobj.toString()+",";
			}
			result = result.substring(0, result.length()-1);
			result += "],";
		}
		result = result.substring(0, result.length()-1);
		result += "]";
		
		
		return result;
	}
}

