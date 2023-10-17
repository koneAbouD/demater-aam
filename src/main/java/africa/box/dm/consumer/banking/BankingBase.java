package africa.box.dm.consumer.banking;

import createaccountproxy.*;
import createaccountproxy.ErrorResponseFlow_Exception;
import createaccountproxy.GetStatusRequestFlow;
import createaccountproxy.Periodicity;
import createaccountproxy.RequestHeader;
import createaccountproxy.ResponseStatusMessage;
import createcustomerproxy.*;
import gercustomerproxy.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigDecimal;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static africa.box.dm.consumer.banking.Factory.*;
import static com.squareup.okhttp.internal.Internal.logger;

@Profile("!test")
@Component
public class BankingBase {

    private static final String CHANEL_CODE = "000";
    private CreateAccountPortType accountStub = new CreateAccount().getCreateAccountPortType();
    private CreateCustomerPortType customerStub = new CreateCustomer().getCreateCustomerPortType();
    private static final String CREATE_ACCOUNT_SERVICE = "createAccount";
    private static final String CREATE_CUSTOMER_DETAILS_SERVICE = "getCustomerDetail";
    private static final String CREATE_ACCOUNT_REQUEST_ID = "004";
    private static final String CREATE_CUSTOMER_SERVICE = "createcustomer";
    private static final String CREATE_CUSTOMER_REQUEST_ID = "0000000013";
    /**
     * Function that create an account
     * @param compteAmplitude
     * @throws ErrorResponseFlow_Exception
     */
    public CreateAccountResponseFlow createAccount(CompteAmplitude compteAmplitude, String customerCode) throws ErrorResponseFlow_Exception {

        /** Create Account Request Flow */
        CreateAccountRequestFlow requestFlow = new CreateAccountRequestFlow();
        /** Pattern builder */
        CreateAccountRequest accountRequest =
                anAccountRequest()
                        .accountType(anAccountType()
                                .customerAccount(aCustomer()
                                        .title(compteAmplitude.typeCompte.equalsIgnoreCase("cheque") ? "COMPTE COURANT": "COMPTE EPARGNE")
                                        .productCode(compteAmplitude.typeCompte.equalsIgnoreCase("cheque") ? "265": "264")
                                        .accountClassCode(compteAmplitude.typeCompte.equalsIgnoreCase("cheque") ? "251100": "253110")
                                        .type("001")
                                        .frequencyOfDebitInterestCalculation(Periodicity.A)
                                        .frequencyOfCreditInterestCalculation(Periodicity.A)
                                        .accountSubjectToDeductionAtSource(BigDecimal.valueOf(1))
                                        .serviceCode("0010")
                                        .accountStatementCode("M")
                                        .accountStatementDeliveryMethod("1")
                                        .branchThatDeliveredTheChequeBook(compteAmplitude.typeCompte.equalsIgnoreCase("cheque") ? compteAmplitude.codeAgence : null)
                                        .build()
                                )
                                .build()
                        )
                        .branchCode(compteAmplitude.codeAgence)
                        .currencyCode("XOF")
                        .customerCode(customerCode)
                        .build();

        requestFlow.setCreateAccountRequest(accountRequest);
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setRequestId(CREATE_ACCOUNT_REQUEST_ID);
        requestHeader.setServiceName(CREATE_ACCOUNT_SERVICE);
        requestHeader.setLanguageCode(compteAmplitude.codeLangueParle);
        requestHeader.setUserCode("MSCO");
        try {
            requestHeader.setTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString()));
            requestHeader.setOriginalTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString()));
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        requestFlow.setRequestHeader(requestHeader);
        try {
            CreateAccountResponseFlow response = accountStub.createAccount(requestFlow);
            logger.info("CreateAccount -> The code status: " + response.getResponseStatus().getStatusCode());
            switch (response.getResponseStatus().getStatusCode()) {
                case "0":
                    logger.info("CreateAccount -> The account code: " + response.getCreateAccountResponse().getAccountIdentifier().getIdentifier().getInternalFormatAccountOurBranch().getAccount());
                    logger.info("CreateAccount -> The Iban: " + response.getCreateAccountResponse().getAccountIdentifier().getIdentifier().getIbanFormatAccount().getValue());
                    logger.info("CreateAccount -> The branch code: " + response.getCreateAccountResponse().getAccountIdentifier().getIdentifier().getInternalFormatAccountOurBranch().getBranch().getCode());

                    break;

                case "1":
                    logger.info("CreateAccount -> The account code: " + response.getCreateAccountResponse().getAccountIdentifier().getIdentifier().getInternalFormatAccountOurBranch().getAccount());
                    logger.info("CreateAccount -> The Iban: " + response.getCreateAccountResponse().getAccountIdentifier().getIdentifier().getIbanFormatAccount().getValue());
                    logger.info("CreateAccount -> The branch code: " + response.getCreateAccountResponse().getAccountIdentifier().getIdentifier().getInternalFormatAccountOurBranch().getBranch().getCode());

                    for (ResponseStatusMessage message : response.getResponseStatus().getMessages().getMessage()) {
                        logger.info("CreateAccount -> The nature: " + message.getNature().value());
                        logger.info("CreateAccount -> The code: " + message.getCode());
                        logger.info("CreateAccount -> The line: " + message.getLine());
                    }

                    break;

                case"-1":
                    for (ResponseStatusMessage message : response.getResponseStatus().getMessages().getMessage()) {
                        logger.info("la nature: " + message.getNature().value());
                        logger.info("le code: " + message.getCode());
                        logger.info("le line: " + message.getLine());
                    }

                    throw new RuntimeException("Payload amplitude incorrecte");

                default:
                    logger.info("Erreur serveur 503");

            }
            return response;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getAccountCreationStatus() throws ErrorResponseFlow_Exception {
        GetStatusRequestFlow requestFlow = new GetStatusRequestFlow();
        //requestFlow.setGetStatusRequest();
        accountStub.getStatus(requestFlow);
    }

    public String createCustomer(CompteAmplitude compteAmplitude) {

        CreateCustomerRequestFlow requestFlow = new CreateCustomerRequestFlow();
        //String customerCode = UUID.randomUUID().toString().replace("-", "").toUpperCase();

        CreateCustomerRequest request = null;
        try {
            request = aCustomerRequest()
                    .customerType("1")
                    .language("001")
                    .titleCode(compteAmplitude.titleCode)
                    .lastName(compteAmplitude.nom)
                    .nameToReturn(compteAmplitude.nomPrenom)
                    .memo(compteAmplitude.memo)
                    .situation(compteAmplitude.codeNationalite,
                            compteAmplitude.codePaysResidence,"IBO")
                    .specificInformation(aCustomerIndividualInfo()
                            .individualGeneralInfo(
                                    anIndividualGeneratInfo()
                                            .firstname(compteAmplitude.prenom)
                                            .middlename("n/a")
                                            .thirdname("n/a")
                                            .familyStatusCode(compteAmplitude.situationMatrimonial)
                                            .holderLegalCapacity(compteAmplitude.codeCapaciteJuridique)
                                            .applicationDateOfLegalCapacity(DatatypeFactory.newInstance().newXMLGregorianCalendar("2022-08-01"))
                                            .build())
                            .birth(compteAmplitude.genre, DatatypeFactory.newInstance().newXMLGregorianCalendar(compteAmplitude.dateNaissance.toString()),compteAmplitude.villeNaissance, compteAmplitude.dptNaissance,compteAmplitude.codePaysNaissance)
                            .idPaper(compteAmplitude.typePiece, compteAmplitude.numPiece, DatatypeFactory.newInstance().newXMLGregorianCalendar(compteAmplitude.dateDelivrancePiece !=null ? compteAmplitude.dateDelivrancePiece.toString() : DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now())), compteAmplitude.lieuDelivrancePiece,compteAmplitude.autorityPiece,DatatypeFactory.newInstance().newXMLGregorianCalendar(compteAmplitude.dateValiditePiece !=null ? compteAmplitude.dateValiditePiece.toString() : DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now())),compteAmplitude.codePaysNaissance)
                            .territoriality(compteAmplitude.codeTerritorialite)
                            .otherAttributes(compteAmplitude.nomMere)
                            .jointAccountsList(compteAmplitude.isCompteConjoint.equals(true) ? aCustomerJointAccount()
                                    .mainCustomerCode(null)
                                    .customerJointAccountList(Arrays.asList(aCustomerJointAccountList()
                                            .jointCustomerCode(compteAmplitude.customerCodeConjoint)
                                            .coHolderType("C")
                                            .linkTyp("MI")
                                            .toBePrintedInTheAddress(true)
                                            .build())
                                    )
                                    .build(): null)
                            .customerBudget("001", BigDecimal.valueOf(compteAmplitude.montantDesRevenus.doubleValue()),BigDecimal.valueOf(0))
                            .professionAndIncomesList(compteAmplitude.categorieProfessionnelle, DatatypeFactory.newInstance().newXMLGregorianCalendar("2022-08-01"), compteAmplitude.codeTrancheRevenus)
                            .build(), null)
                    .generalAttributes(compteAmplitude.codeAgence, compteAmplitude.codeGestionnaire, "03", Boolean.TRUE, compteAmplitude.isCompteConjoint.equals(true) ? "F":"M", "001")
                    .reportingAttributes(aReportingAttributes()
                            .home(compteAmplitude.codeResidenceDeclaration)
                            .economicAgentCode("2420")
                            .activityFieldCode("A0100")
                            .relationshipWithTheBank("000")
                            .creditInfoCentre("2", "000000", "0")
                            .freeAttributes()
                            .build())
                    .addresses("C",
                            compteAmplitude.codeLangueParle,
                            "GE",
                            compteAmplitude.ville,
                            compteAmplitude.adresse !=null && compteAmplitude.adresse !="" ? compteAmplitude.adresse: "n/a",
                            "n/a",
                            compteAmplitude.ville,
                            compteAmplitude.codePostal,
                            compteAmplitude.codePaysResidence,
                            compteAmplitude.email,
                            compteAmplitude.codePaysResidence)
                    .phoneNumbers("002", compteAmplitude.mobile)
                    .emailAddresses("001", compteAmplitude.email)
                    .contacts("n/a", "n/a", "n/a", "na@na.fr")
                    .profile(compteAmplitude.codeProfil)
                    .idPapers(
                            compteAmplitude.typePiece, compteAmplitude.numPiece,
                            DatatypeFactory.newInstance().newXMLGregorianCalendar(compteAmplitude.dateDelivrancePiece !=null ? compteAmplitude.dateDelivrancePiece.toString() : DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now())),
                            compteAmplitude.lieuDelivrancePiece,
                            compteAmplitude.autorityPiece,
                            DatatypeFactory.newInstance().newXMLGregorianCalendar(compteAmplitude.dateValiditePiece !=null ? compteAmplitude.dateValiditePiece.toString() : DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now())))
                    .build();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        requestFlow.setCreateCustomerRequest(request);

        createcustomerproxy.RequestHeader requestHeader = new createcustomerproxy.RequestHeader();

        requestHeader.setRequestId(CREATE_CUSTOMER_REQUEST_ID);
        requestHeader.setServiceName(CREATE_CUSTOMER_SERVICE);
        requestHeader.setLanguageCode(compteAmplitude.codeLangueParle);
        requestHeader.setUserCode("MSCO");
        try {
            requestHeader.setTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString()));
            requestHeader.setOriginalTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString()));
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        requestFlow.setRequestHeader(requestHeader);
        String customerCode = null;

        try{
            CreateCustomerResponseFlow response = customerStub.createCustomer(requestFlow);
            createcustomerproxy.ResponseStatus status = response.getResponseStatus();

            logger.info("createCustomer -> The code status: " + status.getStatusCode());
            switch (status.getStatusCode()) {
                case "0":
                    customerCode = response.getCreateCustomerResponse().getCustomerCode();
                    logger.info("createCustomer -> The customer code: " + customerCode);
                    break;

                case "1":
                    customerCode = response.getCreateCustomerResponse().getCustomerCode();
                    logger.info("createCustomer -> The customer code: " + customerCode);

                    for (createcustomerproxy.ResponseStatusMessage message : status.getMessages().getMessage()) {
                        logger.info("createCustomer -> The nature: " + message.getNature().value());
                        logger.info("createCustomer -> The code: " + message.getCode());
                        logger.info("createCustomer -> The line: " + message.getLine());
                    }

                    break;

                case"-1":
                    for (createcustomerproxy.ResponseStatusMessage message : status.getMessages().getMessage()) {
                        logger.info("createCustomer -> The nature: " + message.getNature().value());
                        logger.info("createCustomer -> The code: " + message.getCode());
                        logger.info("createCustomer -> The line: " + message.getLine());
                    }
                    throw new RuntimeException("Payload amplitude incorrecte");

                default:
                    logger.info("Erreur serveur 503");

            }

            return customerCode;
        }catch (createcustomerproxy.ErrorResponseFlow_Exception exception){
            throw new RuntimeException(exception);
        }
        /*catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        //customerStub.getStatus(new createcustomerproxy.GetStatusRequestFlow().)
    }
    public void disableSSL() {
        try {
            // Créez un gestionnaire de confiance qui ne valide pas les certificats
            TrustManager[] trustAllCertificates = new TrustManager[]{

                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };
            logger.info("LE SSL A ETE DESACTIVE");
            // Obtenez une instance du gestionnaire SSL par défaut
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

            // Configurer la socket factory pour désactiver la validation SSL
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // Ignorer également la vérification de l'hôte
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Optional<Object> getCustomerDetails(String customerCode) throws gercustomerproxy.ErrorResponseFlow_Exception {
        GetCustomerDetailPortType stub = new GetCustomerDetail().getGetCustomerDetailPortType();
        GetCustomerDetailRequestFlow requestFlow =  new GetCustomerDetailRequestFlow();
        GetCustomerDetailRequest request = new GetCustomerDetailRequest();
        CustomerIdentifier identifier = new CustomerIdentifier();
        identifier.setCustomerCode(customerCode);
        request.setCustomerIdentifier(identifier);
        requestFlow.setGetCustomerDetailRequest(request);
        gercustomerproxy.RequestHeader requestHeader = new gercustomerproxy.RequestHeader();
        requestHeader.setChannelCode(CHANEL_CODE);
        requestHeader.setServiceName("CREATE_CUSTOMER_SERVICE");
        requestFlow.setRequestHeader(requestHeader);
        GetCustomerDetailResponseFlow response = stub.getCustomerDetail(requestFlow);
        gercustomerproxy.ResponseStatus status = response.getResponseStatus();
        return Optional.of(response.getGetCustomerDetailResponse());
    }

}
