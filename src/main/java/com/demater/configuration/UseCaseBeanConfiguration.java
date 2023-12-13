package com.demater.configuration;

import com.demater.core.port.*;
import com.demater.core.publisher.AuthEventPublisher;
import com.demater.core.publisher.CityEventPublisher;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.publisher.RoleEventPublisher;
import com.demater.core.publisher.StationEventPublisher;
import com.demater.core.publisher.UserEventPublisher;
import com.demater.core.usecase.admin.CreateUserUseCase;
import com.demater.core.usecase.admin.DeleteUserUseCase;
import com.demater.core.usecase.admin.GetAllUserDetailsUseCase;
import com.demater.core.usecase.admin.UpdateUserUseCase;
import com.demater.core.usecase.auth.AuthenticateUserUseCase;
import com.demater.core.usecase.auth.CheckUserUseCase;
import com.demater.core.usecase.auth.DeleteANonValidatedAccountUseCase;
import com.demater.core.usecase.auth.ResetPasswordUseCase;
import com.demater.core.usecase.auth.SendResetPasswordUseCase;
import com.demater.core.usecase.folder.GetAllFoldersUseCase;
import com.demater.core.usecase.gadget.ConfirmGadgetReceptionUseCase;
import com.demater.core.usecase.gadget.CreateGadgetTypeUseCase;
import com.demater.core.usecase.gadget.CreateGadgetUseCase;
import com.demater.core.usecase.gadget.DeleteGadgetTypeUseCase;
import com.demater.core.usecase.gadget.DeleteGadgetUseCase;
import com.demater.core.usecase.gadget.GetGadgetsTypeUseCase;
import com.demater.core.usecase.gadget.GetGadgetsUseCase;
import com.demater.core.usecase.gadget.UpdateGadgetTypeUseCase;
import com.demater.core.usecase.gadget.UpdateGadgetUseCase;
import com.demater.core.usecase.referential.GetCitiesUseCase;
import com.demater.core.usecase.station.AddUsersToStationUseCase;
import com.demater.core.usecase.station.CreateStationUseCase;
import com.demater.core.usecase.station.DeleteStationUseCase;
import com.demater.core.usecase.station.GetAllStationsUseCase;
import com.demater.core.usecase.station.ImportStationsUseCase;
import com.demater.core.usecase.station.IntegrateGadgetsInStationUseCase;
import com.demater.core.usecase.station.RecoveringGadgetsSentUseCase;
import com.demater.core.usecase.station.RemoveUsersFromStationUseCase;
import com.demater.core.usecase.station.UpdateStationUseCase;
import com.demater.core.usecase.user.GetAllRolesUseCase;
import com.demater.core.usecase.user.GetUserDetailsUseCase;
import com.demater.core.usecase.user.UpdateUserPasswordUseCase;
import com.demater.core.usecase.user.UpdateUserProfileUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfiguration {
    @Bean
    public GetAllFoldersUseCase getAllFoldersUseCase(FolderRepository folderRepository) {
        return new GetAllFoldersUseCase(folderRepository);
    }
    @Bean
    public DeleteUserUseCase getDeleteUserUseCase(UserRepository userRepository, UserEventPublisher userEventPublisher) {
        return new DeleteUserUseCase(userRepository, userEventPublisher);
    }

    @Bean
    public UpdateUserUseCase getUpdateUserUseCase(UserRepository userRepository,
                                                  RoleRepository roleRepository,
                                                  UserEventPublisher userEventPublisher) {
        return new UpdateUserUseCase(userRepository, roleRepository, userEventPublisher);
    }

    @Bean
    public AuthenticateUserUseCase getAuthenticateUserUseCase(Authentication authentication,
                                                              AuthEventPublisher authEventPublisher) {
        return new AuthenticateUserUseCase(authentication, authEventPublisher);
    }

    @Bean
    public CheckUserUseCase getCheckUserUseCase(UserRepository userRepository, AuthEventPublisher authEventPublisher) {
        return new CheckUserUseCase(userRepository, authEventPublisher);
    }

    @Bean
    public CreateUserUseCase getCreateUserUseCase(UserRepository userRepository,
                                                  RoleRepository roleRepository,
                                                  AuthEventPublisher authEventPublisher,
                                                  Password password,
                                                  Notification notification) {
        return new CreateUserUseCase(userRepository,
                roleRepository,
                authEventPublisher,
                password,
                notification);
    }

    @Bean
    public DeleteANonValidatedAccountUseCase getDeleteANonValidatedAccountUseCase(
            UserRepository userRepository,
            AuthEventPublisher authEventPublisher,
            Notification notification
    ) {
        return new DeleteANonValidatedAccountUseCase(userRepository, authEventPublisher, notification);
    }

    @Bean
    public ResetPasswordUseCase getResetPasswordUseCase(UserRepository userRepository,
                                                        Password password,
                                                        Notification notification,
                                                        AuthEventPublisher authEventPublisher) {
        return new ResetPasswordUseCase(userRepository, password, notification, authEventPublisher);
    }

    @Bean
    public SendResetPasswordUseCase getSendResetPasswordUseCase(UserRepository userRepository,
                                                                Password password,
                                                                Notification notification,
                                                                AuthEventPublisher authEventPublisher) {
        return new SendResetPasswordUseCase(userRepository, password, notification, authEventPublisher);
    }

    @Bean
    public ConfirmGadgetReceptionUseCase getConfirmGadgetReceptionUseCase(UserRepository userRepository,
                                                                          GadgetConfirmationRepository gadgetConfirmationRepository,
                                                                          GadgetEventPublisher gadgetEventPublisher) {
        return new ConfirmGadgetReceptionUseCase(userRepository, gadgetConfirmationRepository, gadgetEventPublisher);
    }

    @Bean
    public CreateGadgetTypeUseCase getCreateGadgetTypeUseCase(GadgetTypeRepository gadgetTypeRepository,
                                                              GadgetEventPublisher gadgetEventPublisher) {
        return new CreateGadgetTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Bean
    public DeleteGadgetTypeUseCase getDeleteGadgetTypeUseCase(GadgetTypeRepository gadgetTypeRepository,
                                                              GadgetEventPublisher gadgetEventPublisher) {
        return new DeleteGadgetTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Bean
    public CreateGadgetUseCase getCreateGadgetUseCase(GadgetRepository gadgetRepository,
                                                      GadgetTypeRepository gadgetTypeRepository,
                                                      GadgetEventPublisher gadgetEventPublisher) {
        return new CreateGadgetUseCase(gadgetRepository, gadgetTypeRepository, gadgetEventPublisher);
    }

    @Bean
    public DeleteGadgetUseCase getDeleteGadgetUseCase(GadgetRepository gadgetRepository,
                                                      GadgetEventPublisher gadgetEventPublisher) {
        return new DeleteGadgetUseCase(gadgetRepository, gadgetEventPublisher);
    }

    @Bean
    public GetGadgetsTypeUseCase getGetGadgetsTypeUseCase(GadgetTypeRepository gadgetTypeRepository,
                                                          GadgetEventPublisher gadgetEventPublisher) {
        return new GetGadgetsTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Bean
    public GetGadgetsUseCase getGetGadgetsUseCase(GadgetRepository gadgetRepository,
                                                  GadgetEventPublisher gadgetEventPublisher) {
        return new GetGadgetsUseCase(gadgetRepository, gadgetEventPublisher);
    }

    @Bean
    public UpdateGadgetTypeUseCase getUpdateGadgetTypeUseCase(GadgetTypeRepository gadgetTypeRepository,
                                                              GadgetEventPublisher gadgetEventPublisher) {
        return new UpdateGadgetTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Bean
    public UpdateGadgetUseCase getUpdateGadgetUseCase(GadgetTypeRepository gadgetTypeRepository,
                                                      GadgetRepository gadgetRepository,
                                                      GadgetEventPublisher gadgetEventPublisher) {
        return new UpdateGadgetUseCase(gadgetTypeRepository, gadgetRepository, gadgetEventPublisher);
    }

    @Bean
    public GetCitiesUseCase getGetCitiesUseCase(CityRepository cityRepository, CityEventPublisher cityEventPublisher) {
        return new GetCitiesUseCase(cityRepository, cityEventPublisher);
    }

    @Bean
    public AddUsersToStationUseCase getAddUsersToStationUseCase(StationRepository stationRepository,
                                                                UserRepository userRepository,
                                                                StationEventPublisher stationEventPublisher) {
        return new AddUsersToStationUseCase(stationRepository, userRepository, stationEventPublisher);
    }

    @Bean
    public CreateStationUseCase getCreateStationUseCase(StationRepository stationRepository,
                                                        CityRepository cityRepository,
                                                        StationEventPublisher stationEventPublisher) {
        return new CreateStationUseCase(stationRepository, cityRepository, stationEventPublisher);
    }

    @Bean
    public DeleteStationUseCase getDeleteStationUseCase(StationRepository stationRepository,
                                                        StationDeleteTime stationDeleteTime,
                                                        StationEventPublisher stationEventPublisher) {
        return new DeleteStationUseCase(stationRepository, stationDeleteTime, stationEventPublisher);
    }

    @Bean
    public GetAllStationsUseCase getGetAllStationsUseCase(StationRepository stationRepository,
                                                          StationEventPublisher stationEventPublisher) {
        return new GetAllStationsUseCase(stationRepository, stationEventPublisher);
    }

    @Bean
    public ImportStationsUseCase getImportStationsUseCase(StationRepository stationRepository,
                                                          CityRepository cityRepository,
                                                          StationCSVFile stationCSVFile,
                                                          StationEventPublisher stationEventPublisher) {
        return new ImportStationsUseCase(stationRepository, cityRepository, stationCSVFile, stationEventPublisher);
    }

    @Bean
    public IntegrateGadgetsInStationUseCase getIntegrateGadgetsInStationUseCase(StationRepository stationRepository,
                                                                                StationGadgetRepository stationGadgetRepository,
                                                                                GadgetRepository gadgetRepository,
                                                                                GadgetConfirmationRepository gadgetConfirmationRepository,
                                                                                StationEventPublisher stationEventPublisher) {
        return new IntegrateGadgetsInStationUseCase(stationRepository,
                stationGadgetRepository,
                gadgetRepository,
                gadgetConfirmationRepository,
                stationEventPublisher);
    }

    @Bean
    public RecoveringGadgetsSentUseCase getRecoveringSentGadgetsUseCase(GadgetConfirmationRepository gadgetConfirmationRepository,
                                                                        StationEventPublisher stationEventPublisher) {
        return new RecoveringGadgetsSentUseCase(gadgetConfirmationRepository, stationEventPublisher);
    }

    @Bean
    public RemoveUsersFromStationUseCase getRemoveUsersFromStationUseCase(StationRepository stationRepository,
                                                                          UserRepository userRepository,
                                                                          StationEventPublisher stationEventPublisher) {
        return new RemoveUsersFromStationUseCase(stationRepository, userRepository, stationEventPublisher);
    }

    @Bean
    public UpdateStationUseCase getUpdateStationUseCase(StationRepository stationRepository,
                                                        CityRepository cityRepository,
                                                        StationEventPublisher stationEventPublisher) {
        return new UpdateStationUseCase(stationRepository, cityRepository, stationEventPublisher);
    }


    @Bean
    public GetAllRolesUseCase getAllRolesUseCase(RoleRepository roleRepository, RoleEventPublisher roleEventPublisher) {
        return new GetAllRolesUseCase(roleRepository, roleEventPublisher);
    }

    @Bean
    public GetAllUserDetailsUseCase getAllUserDetailsUseCase(UserRepository userRepository,
                                                             UserEventPublisher userEventPublisher) {
        return new GetAllUserDetailsUseCase(userRepository, userEventPublisher);
    }

    @Bean
    public GetUserDetailsUseCase getUserDetailsUseCase(UserRepository userRepository,
                                                       UserEventPublisher userEventPublisher) {
        return new GetUserDetailsUseCase(userRepository, userEventPublisher);
    }

    @Bean
    public UpdateUserPasswordUseCase getUpdateUserPasswordUseCase(UserRepository userRepository,
                                                                  Password password,
                                                                  Notification notification,
                                                                  UserEventPublisher userEventPublisher) {
        return new UpdateUserPasswordUseCase(userRepository, password, notification, userEventPublisher);
    }

    @Bean
    public UpdateUserProfileUseCase getUpdateUserProfileUseCase(UserRepository userRepository,
                                                                UserEventPublisher userEventPublisher) {
        return new UpdateUserProfileUseCase(userRepository, userEventPublisher);
    }
}
