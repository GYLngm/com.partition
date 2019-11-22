Environement:
** Java version: >= Java 5
** Junit: 4
** IDE: Eclipse Java EE Oxygen(Release 4.7.3a)


Demonstration:
	// optionnelle: import le package com.partition.jar

	import java.util.Arrays;
	import java.util.List;
	import com.partition.*;
	
	// instantialiser Partition Object.
		Partition helper = new Partition();
	// le methode "partition" prend un premier parametre de List<>, le deuxiem est un taille en int
	// creer une liste a traitee.
		List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
		int taille = 2;

	// appeller le methode <<partition>>, entrer liste comme premier parametre, taille le deuxiem.
		List<List<Integer>> list2PartSet = helper.partition(liste, taille);// expecter {{1,2},{3,4},{5}}
	// vous pouvez manipuler la liste "list2PartSet" vous-meme, ou bien vous pouvez aussi voir le contenue de liste avec le methode static "Partition.displayString(List<>)"

	// voir les resultats
		System.out.println(Partition.displayString(list2PartSet)+", length: "+list2PartSet.size()); // [[1,2],[3,4],[5]], length: 3

	/*        Optionnelle               */
	//Si vous voulez "run on terminal", voir ici (Windows 10 Powershell)
	PS _PathToFolder_\test_java_20191122\com.partition> javac -d ./ ./src/main/java/com/partition/Partition.java ./src/main/java/com/partition/Client.java
	
	PS _PathToFolder_\test_java_20191122\com.partition> java com.partition.Client 2 1,2,3,4,5,6,7,8,9 // entrer le taille en premier, ajouter un WHITESPACE et apres la liste