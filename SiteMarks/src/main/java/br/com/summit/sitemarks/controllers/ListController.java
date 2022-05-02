package br.com.summit.sitemarks.controllers;

import br.com.summit.sitemarks.models.MarkObjectModel;
import br.com.summit.sitemarks.models.MarkFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListController {

    public void initializer() {

        String listPath = "Lista.lst";
        File file = new File(listPath);

        if (!file.exists()){
            System.out.println("< < Lista.lst doesn't exist > >" );
            System.out.println("Insert the path of List file> ");
            Scanner s = new Scanner(System.in);
            listPath = s.nextLine();
        }


        if (!listPath.equals("Lista.lst")) {
            ListController openFile = new ListController();
            ArrayList lstFile = (ArrayList) openFile.listReader(listPath);

            XmlFacade facade = new XmlFacade("teste.xml");
            List<MarkObjectModel> Marks;
            MarkObjectModel markInsert;

            Scanner s = new Scanner(System.in);
            String entry;
            Marks = facade.loadList();

            for (Object o : lstFile) {

                System.out.println(o);
                System.out.print("(A)dd     (N)ext  > ");
                entry = s.next();

                switch (entry) {
                    case "A", "a" -> {
                        System.out.println("Add");
                        markInsert = MarkFactory.createMark((String) o);
                        Marks.add(markInsert);
                        System.out.println();

                    }
                    case "N", "n" -> {
                    }
                    default -> {
                        System.out.print("Invalid option");
                        System.out.println();
                    }
                }
                facade.saveList(Marks);
            }
        }
    }


    public List listReader(String listPath) {

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(listPath));
            while (s.hasNextLine()) {
                list.add(s.next());
            }
            s.close();

            return list;

        } catch (Exception e) {
            System.out.println(" < < File not found > > ");
            System.out.printf("");
        }

        return list;
    }
    public List listReader() throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("default.lst"));
            while (s.hasNextLine()) {
                list.add(s.next());
            }
            s.close();

            return list;

        } catch (Exception e) {
            System.out.println(" < < File not found > > ");
            System.out.printf("");
        }

        return list;
    }
}
