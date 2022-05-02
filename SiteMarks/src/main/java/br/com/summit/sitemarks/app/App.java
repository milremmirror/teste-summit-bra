package br.com.summit.sitemarks.app;

import br.com.summit.sitemarks.controllers.ListController;
import br.com.summit.sitemarks.controllers.XmlFacade;
import br.com.summit.sitemarks.models.MarkObjectModel;
import br.com.summit.sitemarks.models.MarkFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
		String entry = "";
		int index;

		String initialPath = "teste.xml";

		XmlFacade facade = new XmlFacade(initialPath);

		List<MarkObjectModel> Marks = null;
		MarkObjectModel markInsert;

		ListController listController = new ListController();

		listController.initializer();

		do {
			System.out.println( "SiteMarks - (" + initialPath + ")");

			Marks = facade.loadList();

			System.out.println("");
			for (MarkObjectModel i : Marks) {
				int position = Marks.indexOf(i);
				position++;
				System.out.print("(" + position + ")   ");
				System.out.println(i);
			}
			System.out.println("");

			System.out.println("(A)dd      (E)dit      (R)emove      (Q)uit");
			System.out.println();
			System.out.print("Select an Operation > ");
			entry = s.next();
			System.out.println();

			switch (entry) {
				case "A", "a" -> {
					System.out.println("Add a new SiteMark >");
					markInsert = MarkFactory.createMark();
					Marks.add(markInsert);
				}
				case "E", "e" -> {
					System.out.print("Number of SiteMark to edit> ");
					index = s.nextInt();
					index--;
					Marks.remove(index);
					markInsert = MarkFactory.createMark();
					Marks.add(index, markInsert);
				}
				case "R", "r" -> {
					System.out.print("Number of SiteMark to remove> ");
					index = s.nextInt();
					index--;
					Marks.remove(index);
				}
				case "Q", "q" -> {
					System.out.print("Quit");
					entry = "q";
				}
				default -> {
					System.out.print("Invallid entry. Please select a valid option");
					System.out.println();
				}
			}
			facade.saveList(Marks);

		} while (entry != "q");
		s.close();


	}
}
