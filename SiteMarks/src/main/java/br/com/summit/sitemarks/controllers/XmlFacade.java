package br.com.summit.sitemarks.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.com.summit.sitemarks.models.MarkObjectModel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlFacade {


	private String path;

	public String getPath() {
		return this.path;
	}

	public XmlFacade(String path) {
		this.path = path;
	}


	public void saveList(List<MarkObjectModel> list) {

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Marklist", list.getClass());
		xstream.alias("Mark", MarkObjectModel.class);
		xstream.toXML(list);
		String xml = xstream.toXML(list);

		FileWriter writer = null;
		try {
			File output = new File(path);
			writer = new FileWriter(output);
			writer.write(xml);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (writer != null) {
					writer.flush();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<MarkObjectModel> loadList() {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Marklist", List.class);
		xstream.alias("Mark", MarkObjectModel.class);
		xstream.allowTypes(new Class[] { MarkObjectModel.class });

		String xmlString = "";
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(path));
			xmlString = new String(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return (List<MarkObjectModel>) xstream.fromXML(xmlString);
	}
}