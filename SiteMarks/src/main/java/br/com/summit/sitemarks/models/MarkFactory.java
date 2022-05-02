package br.com.summit.sitemarks.models;

import java.util.Scanner;

public class MarkFactory {

    public static MarkObjectModel createMark(){
        Scanner s = new Scanner(System.in);
        MarkObjectModel markObjectModel = new MarkObjectModel();

        System.out.print("URL> " );
        markObjectModel.setUrl(s.nextLine());


        System.out.print("Description> " );
        markObjectModel.setDescription(s.nextLine());

        return markObjectModel;
    }

    public static MarkObjectModel createMark(String url){
        Scanner s = new Scanner(System.in);
        MarkObjectModel markObjectModel = new MarkObjectModel();

        System.out.print("URL> " );
        markObjectModel.setUrl(url);


        System.out.print("Description> " );
        markObjectModel.setDescription(s.nextLine());

        return markObjectModel;
    }
}
