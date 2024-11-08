package pojos.gmibank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCountryPojo implements Serializable {

    private String name;

    private List<StatesPojo> states;

    public PostCountryPojo() {
    }

    public PostCountryPojo(String name, List<StatesPojo> states) {
        this.name = name;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatesPojo> getStates() {
        return states;
    }

    public void setStates(List<StatesPojo> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CountryPojo{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
