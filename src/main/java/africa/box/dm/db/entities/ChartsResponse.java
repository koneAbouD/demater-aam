package africa.box.dm.db.entities;

import java.util.List;

public class ChartsResponse {
    private String appName;
    private List<String> labels;
    private List<ChartsDataSet> datasets;

    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public List<String> getLabels() {
        return labels;
    }
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
    public List<ChartsDataSet> getDatasets() {
        return datasets;
    }
    public void setDatasets(List<ChartsDataSet> datasets) {
        this.datasets = datasets;
    }
}
