package com.demater.infrastructure.provider;

import com.demater.core.domain.referential.City;
import com.demater.core.domain.station.Station;
import com.demater.core.port.StationCSVFile;
import org.apache.commons.csv.CSVFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.demater.core.domain.referential.EStatus.ACTIVATED;
import static java.nio.charset.StandardCharsets.UTF_8;

@Component
public class StationCSVFileProvider implements StationCSVFile {
    public static String TYPE = "text/csv";
    static String[] HEADERS = { "description", "commune", "adresse", "centre de coût" };

    @Override
    public boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    @Override
    public List<Station> csvToStations(MultipartFile file) {
        try (var fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), UTF_8))) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            var stations = new ArrayList<Station>();
            var csvRecords = csvFormat.parse(fileReader);

            for(var csvRecord : csvRecords) {
                var station = new Station();
                var city = new City();
                city.setDesignation(csvRecord.get("commune").trim().toLowerCase());
                station.updateForCSV(csvRecord.get("description"),
                        csvRecord.get("adresse").trim(),
                        city,
                        csvRecord.get("centre de coût").trim(),
                        ACTIVATED);
                stations.add(station);
            }

            return stations;
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
        }
    }
}
