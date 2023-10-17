package africa.box.dm.service;


import africa.box.dm.db.entities.ChartsDataSet;
import africa.box.dm.db.entities.ChartsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartsService {
    public ChartsResponse getDummyData1(){
        ChartsResponse chartsResponse = new ChartsResponse();
        chartsResponse.setAppName("Test app 1");

        List<String> labels = new ArrayList<>(); // => Dates
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        chartsResponse.setLabels(labels);

        List<ChartsDataSet> datasets = new ArrayList<>(); // => Les Courbes
        ChartsDataSet dataset = new ChartsDataSet(); // Une courbe
        List<Integer> value = new ArrayList<>();
        value.add(65); // La valeur de la courbe à une date précise
        value.add(59); // La valeur de la courbe à une date précise
        value.add(80); // La valeur de la courbe à une date précise
        value.add(81); // La valeur de la courbe à une date précise
        value.add(56); // La valeur de la courbe à une date précise
        value.add(55); // La valeur de la courbe à une date précise
        value.add(40); // La valeur de la courbe à une date précise
        dataset.setName("My First dataset");
        dataset.setValue(value);
        datasets.add(dataset);

        dataset = new ChartsDataSet();
        value = new ArrayList<>();
        value.add(28);
        value.add(48);
        value.add(40);
        value.add(19);
        value.add(86);
        value.add(27);
        value.add(90);
        dataset.setName("My Second dataset");
        dataset.setValue(value);
        datasets.add(dataset);

        chartsResponse.setDatasets(datasets);

        return chartsResponse;
    }

    public ChartsResponse getDummyData2(){
        ChartsResponse chartsResponse = new ChartsResponse();
        chartsResponse.setAppName("Test app 2");

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("December");
        chartsResponse.setLabels(labels);

        List<ChartsDataSet> datasets = new ArrayList<>();
        ChartsDataSet dataset = new ChartsDataSet();
        List<Integer> value = new ArrayList<>();
        value.add(45);
        value.add(59);
        value.add(30);
        value.add(81);
        value.add(56);
        value.add(55);
        value.add(40);
        dataset.setName("My First dataset");
        dataset.setValue(value);
        datasets.add(dataset);

        dataset = new ChartsDataSet();
        value = new ArrayList<>();
        value.add(28);
        value.add(70);
        value.add(40);
        value.add(19);
        value.add(20);
        value.add(27);
        value.add(90);
        dataset.setName("My Second dataset");
        dataset.setValue(value);
        datasets.add(dataset);

        chartsResponse.setDatasets(datasets);

        return chartsResponse;
    }
}
