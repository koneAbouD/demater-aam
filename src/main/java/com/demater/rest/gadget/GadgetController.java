package com.demater.rest.gadget;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.usecase.gadget.*;
import com.demater.rest.gadget.in.GadgetCreateIn;
import com.demater.rest.gadget.in.GadgetTypeIn;
import com.demater.rest.gadget.in.GadgetUpdateIn;
import com.demater.rest.gadget.out.GadgetConfirmationOut;
import com.demater.rest.gadget.out.GadgetOut;
import com.demater.rest.gadget.out.GadgetTypeOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tags(value = {@Tag(name = "Gadgets", description = "Gadgets in store of station")})
@RestController
@RequestMapping("gadgets")
@RequiredArgsConstructor
public class GadgetController {
    private final CreateGadgetTypeUseCase createGadgetType;
    private final UpdateGadgetTypeUseCase updateGadgetType;
    private final DeleteGadgetTypeUseCase deleteGadgetType;
    private final GetGadgetsTypeUseCase getGadgetsType;
    private final CreateGadgetUseCase createGadget;
    private final UpdateGadgetUseCase updateGadget;
    private final DeleteGadgetUseCase deleteGadget;
    private final GetGadgetsUseCase getGadgets;
    private final ConfirmGadgetReceptionUseCase confirmGadgetReception;
    private final ObjectMapper objectMapper;

    @PostMapping("/types/{name}")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Creating gadget type")
    public ResponseEntity<GadgetTypeOut> createGadgetType(@PathVariable String name) {
        GadgetType gadgetType = createGadgetType.execute(name);
        return new ResponseEntity<>(objectMapper.convertValue(gadgetType, GadgetTypeOut.class), CREATED);
    }

    @PutMapping("/types")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Updating gadget type")
    public ResponseEntity<GadgetTypeOut> updateGadgetType(@Validated @RequestBody GadgetTypeIn request) {
        GadgetType gadgetTypeToUpdate = objectMapper.convertValue(request, GadgetType.class);
        GadgetType gadgetType = updateGadgetType.execute(gadgetTypeToUpdate);
        return new ResponseEntity<>(objectMapper.convertValue(gadgetType, GadgetTypeOut.class), OK);
    }

    @DeleteMapping("/types/{id}")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Deleting gadget type")
    public ResponseEntity<Void> deleteGadgetType(@PathVariable Long id) {
        deleteGadgetType.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/types")
    @Operation(summary = "Getting all gadgets types")
    public ResponseEntity<List<GadgetTypeOut>> getAllGadgetsTypes() {
        List<GadgetType> gadgetTypes = getGadgetsType.execute();
        List<GadgetTypeOut> results = gadgetTypes.stream()
                .map(g -> objectMapper.convertValue(g, GadgetTypeOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Creating gadget")
    public ResponseEntity<GadgetOut> createGadget(@Validated @RequestBody GadgetCreateIn request) {
        Gadget gadget = objectMapper.convertValue(request, Gadget.class);
        Gadget gadgetSaved = createGadget.execute(gadget);
        return new ResponseEntity<>(objectMapper.convertValue(gadgetSaved, GadgetOut.class), CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Updating gadget")
    public ResponseEntity<GadgetOut> updateGadget(@PathVariable UUID id, @Validated @RequestBody GadgetUpdateIn request) {
        Gadget gadget = objectMapper.convertValue(request, Gadget.class);
        Gadget gadgetUpdated = updateGadget.execute(id, gadget);
        return new ResponseEntity<>(objectMapper.convertValue(gadgetUpdated, GadgetOut.class), OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Deleting gadget")
    public ResponseEntity<Void> deleteGadget(@PathVariable UUID id) {
        deleteGadget.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_ADMIN')")
    @Operation(summary = "Getting all gadgets")
    public ResponseEntity<List<GadgetOut>> getGadgets(@RequestParam(required = false) Map<String, String> query) {
        List<Gadget> gadgets = getGadgets.execute(query);
        List<GadgetOut> results = gadgets.stream()
                .map(g -> objectMapper.convertValue(g, GadgetOut.class))
                .toList();
        return new ResponseEntity<>(results, OK);
    }

    @PutMapping("/{uuid}/confirm-reception")
    @Operation(summary = "Confirm gadget reception")
    public ResponseEntity<GadgetConfirmationOut> confirmGadgetReception(@PathVariable UUID uuid, Principal principal) {
        GadgetConfirmation gadgetConfirmation = confirmGadgetReception.execute(principal.getName(), uuid);
        return new ResponseEntity<>(objectMapper.convertValue(gadgetConfirmation, GadgetConfirmationOut.class), OK);
    }
}
