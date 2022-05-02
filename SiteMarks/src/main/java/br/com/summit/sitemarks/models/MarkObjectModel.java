package br.com.summit.sitemarks.models;

public class MarkObjectModel {

	private String url;
	private String description;


	public String getUrl() {
		return url;
	}

	public String setUrl(String url) {
		return this.url = urlChecker(url);
	}

	public String urlChecker(String entryUrl) {

		String protocol = "http://";
		String checkedUrl;

		if (!entryUrl.contains(protocol)){
			checkedUrl = protocol.concat(entryUrl);
			System.out.println(checkedUrl);
			return checkedUrl;
		}
		return entryUrl;

	}

	public String getDescription() {
		return description;
	}

	public String setDescription(String description) {
		return this.description = descriptionLimit(description);
	}

	public String descriptionLimit (String entryDescription) {

		int maxLength = 40;

		StringBuilder stringBuilder = new StringBuilder(entryDescription);

		while (stringBuilder.length() < maxLength){
			stringBuilder.append(".");
		}

		System.out.println(stringBuilder);
		return stringBuilder.toString();

	}

	public String toString() {
		return this.getDescription() +"   "+ this.getUrl();
	}
}