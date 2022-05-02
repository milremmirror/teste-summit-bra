package br.com.summit.phoneNumber;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountryFacade {
    public static void countryDetector(String countryCode) {

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("root", List.class);
        xstream.alias("countries", CountryModel.class);

        xstream.allowTypes(new Class[] { CountryModel.class });

        String xmlString = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("Countries.xml"));
            xmlString = new String(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<CountryModel> countries = (List<CountryModel>) xstream.fromXML(xmlString);


        for (CountryModel countryModel : countries) {
            if (countryModel.code.contains(countryCode)){
                System.out.println(countryModel.name);
            }
        }
    }
}
