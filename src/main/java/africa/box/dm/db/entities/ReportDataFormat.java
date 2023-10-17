package africa.box.dm.db.entities;

public class ReportDataFormat {
    private String labels;
    private String datasets;

    public ReportDataFormat() {
    }

    public ReportDataFormat(String labels, String datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getDatasets() {
        return datasets;
    }

    public void setDatasets(String datasets) {
        this.datasets = datasets;
    }
}
