package com.demater.core.port;

import com.demater.core.domain.station.Station;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StationCSVFile {
    boolean hasCSVFormat(MultipartFile file);
    List<Station> csvToStations(MultipartFile file);
}
