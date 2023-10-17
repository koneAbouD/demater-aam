package africa.box.dm.db.entities;

import java.util.List;

public class ChartsDataSet {
    public String name;
    public List<Integer> value;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Integer> getValue() {
        return value;
    }
    public void setValue(List<Integer> value) {
        this.value = value;
    }
}
