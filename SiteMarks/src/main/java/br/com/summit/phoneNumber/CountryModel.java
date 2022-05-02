package br.com.summit.phoneNumber;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("countries")
public class CountryModel {

    @XStreamAlias("code")
    String code;

    @XStreamAlias("name")
    String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
