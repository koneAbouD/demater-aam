package com.demater.rest.station;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.gadget.GadgetAndNumber;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.station.Station;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.usecase.station.*;
import com.demater.rest.common.in.GadgetAndNumberIn;
import com.demater.rest.common.out.UserOut;
import com.demater.rest.gadget.out.GadgetConfirmationOut;
import com.demater.rest.gadget.out.GadgetOut;
import com.demater.rest.station.in.StationCreateIn;
import com.demater.rest.station.in.StationUpdateIn;
import com.demater.rest.station.out.StationGadgetOut;
import com.demater.rest.station.out.StationOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tags(value = {@Tag(name = "Station", description = "TotalEnergies gas station")})
@RestController
@RequestMapping("stations")
@RequiredArgsConstructor
public class
StationController {
    private final CreateStationUseCase createStation;
    private final UpdateStationUseCase updateStation;
    private final DeleteStationUseCase deleteStation;
    private final GetAllStationsUseCase getAllStations;
    private final ImportStationsUseCase importStations;
    private final AddUsersToStationUseCase addUsersToStation;
    private final RemoveUsersFromStationUseCase removeUsersFromStation;
    private final IntegrateGadgetsInStationUseCase integrateGadgetsInStation;
    private final RecoveringGadgetsSentUseCase recoveringSentGadgets;
    private final ObjectMapper objectMapper;

    @PostMapping
    @Operation(summary = "Creating new station by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<StationOut> createStation(@Validated @RequestBody StationCreateIn request) {
        Station station = objectMapper.convertValue(request, Station.class);
        Station stationSaved = createStation.execute(station);
        return new ResponseEntity<>(objectMapper.convertValue(stationSaved, StationOut.class), CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating a station by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<StationOut> updateStation(@PathVariable UUID id, @Validated @RequestBody StationUpdateIn request) {
        Station station = objectMapper.convertValue(request, Station.class);
        Station stationUpdated = updateStation.execute(id, station);
        return new ResponseEntity<>(objectMapper.convertValue(stationUpdated, StationOut.class), OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleting a station by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<Void> deleteStation(@PathVariable UUID id) {
        deleteStation.execute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Get all stations by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<List<StationOut>> getStations() {
        List<Station> stations = getAllStations.execute();
        List<StationOut> results = stations.stream()
                .map(s -> objectMapper.convertValue(s, StationOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    @Operation(summary = "Import stations from CSV by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<List<StationOut>> importStations(@RequestParam MultipartFile file) {
        List<Station> stations = importStations.execute(file);
        List<StationOut> results = stations.stream()
                .map(s -> objectMapper.convertValue(s, StationOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping("/{id}/users/{logins}/add")
    @Operation(summary = "Adding users to a station by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<StationOut> addUsers(@PathVariable UUID id, @PathVariable Set<String> logins) {
        Station station = addUsersToStation.execute(id, logins);
        return new ResponseEntity<>(objectMapper.convertValue(station, StationOut.class), OK);
    }

    @DeleteMapping("/{id}/users/{logins}/remove")
    @Operation(summary = "Removing users to a station by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<StationOut> removeUsers(@PathVariable UUID id, @PathVariable Set<String> logins) {
        Station station = removeUsersFromStation.execute(id, logins);
        return new ResponseEntity<>(objectMapper.convertValue(station, StationOut.class), OK);
    }

    @PostMapping("/{id}/integrate-gadgets")
    @Operation(summary = "Integrate gadgets for station by admin")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<Set<StationGadgetOut>> integrateGadgetsInStation(@PathVariable UUID id,
                                                                           @Validated @RequestBody Set<GadgetAndNumberIn> request) {
        Set<GadgetAndNumber> gadgetAndNumbers = request.stream()
                .map(r -> objectMapper.convertValue(r, GadgetAndNumber.class))
                .collect(toSet());
        Set<StationGadget> stationGadgets = integrateGadgetsInStation.execute(id, gadgetAndNumbers);
        Set<StationGadgetOut> results = stationGadgets.stream()
                .map(s -> objectMapper.convertValue(s, StationGadgetOut.class))
                .collect(toSet());
        return new ResponseEntity<>(results, CREATED);
    }

    @GetMapping("/recovering-gadgets")
    @Operation(summary = "Recovering sent gadgets by admin",
            description = "We can use query : station=station 11&gadget=Chargeur de&status=CONFIRMED&dates=2023-09-01;2023-09-04")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    public ResponseEntity<List<GadgetConfirmationOut>> recoveringSentGadgets(@RequestParam(required = false) Map<String, String> query) {
        List<GadgetConfirmation> gadgetConfirmations = recoveringSentGadgets.execute(query);
        List<GadgetConfirmationOut> results = gadgetConfirmations.stream()
                .map(this::buildGadgetConfirmation)
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    private GadgetConfirmationOut buildGadgetConfirmation(GadgetConfirmation gadgetConfirmation) {
        StationOut station = objectMapper.convertValue(gadgetConfirmation.getStationGadget().getStation(), StationOut.class);
        GadgetOut gadget = objectMapper.convertValue(gadgetConfirmation.getStationGadget().getGadget(), GadgetOut.class);
        UserOut user = objectMapper.convertValue(gadgetConfirmation.getUser(), UserOut.class);
        return new GadgetConfirmationOut(
                gadgetConfirmation.getId(),
                station,
                gadget,
                gadgetConfirmation.getGadgetNumberReceived(),
                gadgetConfirmation.getIntegrationDate(),
                gadgetConfirmation.getStatus(),
                gadgetConfirmation.getConfirmationDate(),
                user
        );
    }
}
