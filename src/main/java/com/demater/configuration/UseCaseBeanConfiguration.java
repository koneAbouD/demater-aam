package com.demater.configuration;

import com.demater.core.port.*;
import com.demater.core.publisher.*;
import com.demater.core.usecase.account.*;
import com.demater.core.usecase.admin.CreateUserUseCase;
import com.demater.core.usecase.admin.DeleteUserUseCase;
import com.demater.core.usecase.admin.GetAllUserDetailsUseCase;
import com.demater.core.usecase.admin.UpdateUserUseCase;
import com.demater.core.usecase.auth.AuthenticateUserUseCase;
import com.demater.core.usecase.auth.CheckUserUseCase;
import com.demater.core.usecase.auth.DeleteANonValidatedAccountUseCase;
import com.demater.core.usecase.auth.ResetPasswordUseCase;
import com.demater.core.usecase.auth.SendResetPasswordUseCase;
import com.demater.core.usecase.customer.CreateCustomerUserCase;
import com.demater.core.usecase.customer.UpdateCustomerOfCoordinatedUserCase;
import com.demater.core.usecase.customer.UpdateCustomerOfGeneralAttributUserCase;
import com.demater.core.usecase.param_value.*;
import com.demater.core.usecase.user.GetAllRolesUseCase;
import com.demater.core.usecase.user.GetUserDetailsUseCase;
import com.demater.core.usecase.user.UpdateUserPasswordUseCase;
import com.demater.core.usecase.user.UpdateUserProfileUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfiguration {
    @Bean
    public GetAllLegalCapacityUseCase getAllLegalCapacityUseCase(LegalCapacityRepository legalCapacityRepository) {
        return new GetAllLegalCapacityUseCase(legalCapacityRepository);
    }
    @Bean
    public GetAllEmployerTypeUseCase getAllEmployerTypeUseCase(EmployerTypeRepository employerTypeRepository) {
        return new GetAllEmployerTypeUseCase(employerTypeRepository);
    }
    @Bean
    public GetAllCustomerTypeUseCase getAllCustomerTypeUseCase(CustomerTypeRepository customerTypeRepository) {
        return new GetAllCustomerTypeUseCase(customerTypeRepository);
    }
    @Bean
    public GetAllCatProfessionalUseCase getAllCatProfessionalUseCase(CatProfessionalRepository catProfessionalRepository) {
        return new GetAllCatProfessionalUseCase(catProfessionalRepository);
    }
    @Bean
    public CreateLegalCapacityUseCase createLegalCapacityUseCase(LegalCapacityRepository legalCapacityRepository) {
        return new CreateLegalCapacityUseCase(legalCapacityRepository);
    }
    @Bean
    public CreateEmployerTypeUseCase employerTypeRepository(EmployerTypeRepository employerTypeRepository) {
        return new CreateEmployerTypeUseCase(employerTypeRepository);
    }
    @Bean
    public CreateCustomerTypeUseCase createCustomerTypeUseCase(CustomerTypeRepository customerTypeRepository) {
        return new CreateCustomerTypeUseCase(customerTypeRepository);
    }
    @Bean
    public CreateCatProfessionalUseCase createCatProfessionalUseCase(CatProfessionalRepository catProfessionalRepository) {
        return new CreateCatProfessionalUseCase(catProfessionalRepository);
    }
    @Bean
    public UpdateCustomerOfGeneralAttributUserCase updateCustomerOfGeneralAttributUserCase(CustomerRepository customerRepository,
                                                                                           ProfessionRepository professionRepository,
                                                                                           MaritalStatusRepository maritalStatusRepository,
                                                                                           FamilyStatusRepository familyStatusRepository) {
        return new UpdateCustomerOfGeneralAttributUserCase(customerRepository,
                professionRepository,
                maritalStatusRepository,
                familyStatusRepository);
    }
    @Bean
    public UpdateCustomerOfCoordinatedUserCase updateCustomerOfCoordinatedUserCase(CustomerRepository customerRepository,
                                                                                   NationalityRepository nationalityRepository,
                                                                                   LanguageRepository languageRepository,
                                                                                   AddressRepository addressRepository) {
        return new UpdateCustomerOfCoordinatedUserCase(customerRepository,
                nationalityRepository,
                languageRepository,
                addressRepository);
    }
    @Bean
    public CreateCustomerUserCase createCustomerUserCase(CustomerRepository customerRepository) {
        return new CreateCustomerUserCase(customerRepository);
    }
    @Bean
    public GetAllAccountsUseCase getAllAccountsUseCase(AccountRepository accountRepository,
                                                       AccountEventPublisher accountEventPublisher) {
        return new GetAllAccountsUseCase(accountRepository, accountEventPublisher);
    }
    @Bean
    public CreateAccountUseCase createAccountUseCase(AccountRepository accountRepository,
                                                     AccountTypeRepository accountTypeRepository,
                                                     CustomerTypeRepository customerTypeRepository) {
        return new CreateAccountUseCase(accountRepository, accountTypeRepository, customerTypeRepository);
    }
    @Bean
    public GetAllAccountTypeUseCase getAllAccountTypeUseCase(AccountTypeRepository accountTypeRepository) {
        return new GetAllAccountTypeUseCase(accountTypeRepository);
    }
    @Bean
    public CreateAccountTypeUseCase getCreateAccountTypeUseCase(AccountTypeRepository accountTypeRepository) {
        return new CreateAccountTypeUseCase(accountTypeRepository);
    }
    @Bean
    public DeleteUserUseCase getDeleteUserUseCase(UserRepository userRepository,
                                                  UserEventPublisher userEventPublisher) {
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
    public CheckUserUseCase getCheckUserUseCase(UserRepository userRepository,
                                                AuthEventPublisher authEventPublisher) {
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
    public GetAllRolesUseCase getAllRolesUseCase(RoleRepository roleRepository,
                                                 RoleEventPublisher roleEventPublisher) {
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
