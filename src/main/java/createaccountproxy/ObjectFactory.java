
package createaccountproxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the createaccountproxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ErrorResponseFlow_QNAME = new QName("http://soprabanking.com/amplitude", "errorResponseFlow");
    private final static QName _GetStatusRequestFlow_QNAME = new QName("http://soprabanking.com/amplitude", "getStatusRequestFlow");
    private final static QName _CreateAccountRequestFlow_QNAME = new QName("http://soprabanking.com/amplitude", "createAccountRequestFlow");
    private final static QName _GetStatusResponseFlow_QNAME = new QName("http://soprabanking.com/amplitude", "getStatusResponseFlow");
    private final static QName _CreateAccountResponseFlow_QNAME = new QName("http://soprabanking.com/amplitude", "createAccountResponseFlow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: createaccountproxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStatusResponseFlow }
     * 
     */
    public GetStatusResponseFlow createGetStatusResponseFlow() {
        return new GetStatusResponseFlow();
    }

    /**
     * Create an instance of {@link CreateAccountResponseFlow }
     * 
     */
    public CreateAccountResponseFlow createCreateAccountResponseFlow() {
        return new CreateAccountResponseFlow();
    }

    /**
     * Create an instance of {@link ErrorResponseFlow }
     * 
     */
    public ErrorResponseFlow createErrorResponseFlow() {
        return new ErrorResponseFlow();
    }

    /**
     * Create an instance of {@link GetStatusRequestFlow }
     * 
     */
    public GetStatusRequestFlow createGetStatusRequestFlow() {
        return new GetStatusRequestFlow();
    }

    /**
     * Create an instance of {@link CreateAccountRequestFlow }
     * 
     */
    public CreateAccountRequestFlow createCreateAccountRequestFlow() {
        return new CreateAccountRequestFlow();
    }

    /**
     * Create an instance of {@link ResponseHeader }
     * 
     */
    public ResponseHeader createResponseHeader() {
        return new ResponseHeader();
    }

    /**
     * Create an instance of {@link Language }
     * 
     */
    public Language createLanguage() {
        return new Language();
    }

    /**
     * Create an instance of {@link Branch }
     * 
     */
    public Branch createBranch() {
        return new Branch();
    }

    /**
     * Create an instance of {@link FileaccountNature }
     * 
     */
    public FileaccountNature createFileaccountNature() {
        return new FileaccountNature();
    }

    /**
     * Create an instance of {@link AccountPhoneNumber }
     * 
     */
    public AccountPhoneNumber createAccountPhoneNumber() {
        return new AccountPhoneNumber();
    }

    /**
     * Create an instance of {@link AccountPhoneNumbers }
     * 
     */
    public AccountPhoneNumbers createAccountPhoneNumbers() {
        return new AccountPhoneNumbers();
    }

    /**
     * Create an instance of {@link AccountChequeBookAddress }
     * 
     */
    public AccountChequeBookAddress createAccountChequeBookAddress() {
        return new AccountChequeBookAddress();
    }

    /**
     * Create an instance of {@link AdditionalData }
     * 
     */
    public AdditionalData createAdditionalData() {
        return new AdditionalData();
    }

    /**
     * Create an instance of {@link CreateAccountAddressRequest }
     * 
     */
    public CreateAccountAddressRequest createCreateAccountAddressRequest() {
        return new CreateAccountAddressRequest();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link AdditionalDataValue }
     * 
     */
    public AdditionalDataValue createAdditionalDataValue() {
        return new AdditionalDataValue();
    }

    /**
     * Create an instance of {@link ResponseStatus }
     * 
     */
    public ResponseStatus createResponseStatus() {
        return new ResponseStatus();
    }

    /**
     * Create an instance of {@link ResponseStatusMessages }
     * 
     */
    public ResponseStatusMessages createResponseStatusMessages() {
        return new ResponseStatusMessages();
    }

    /**
     * Create an instance of {@link AccountContact }
     * 
     */
    public AccountContact createAccountContact() {
        return new AccountContact();
    }

    /**
     * Create an instance of {@link ErrorInformation }
     * 
     */
    public ErrorInformation createErrorInformation() {
        return new ErrorInformation();
    }

    /**
     * Create an instance of {@link AccountCreationType }
     * 
     */
    public AccountCreationType createAccountCreationType() {
        return new AccountCreationType();
    }

    /**
     * Create an instance of {@link IbanFormatAccount }
     * 
     */
    public IbanFormatAccount createIbanFormatAccount() {
        return new IbanFormatAccount();
    }

    /**
     * Create an instance of {@link Accountproduct }
     * 
     */
    public Accountproduct createAccountproduct() {
        return new Accountproduct();
    }

    /**
     * Create an instance of {@link CustomerAccount }
     * 
     */
    public CustomerAccount createCustomerAccount() {
        return new CustomerAccount();
    }

    /**
     * Create an instance of {@link ResponseStatusMessage }
     * 
     */
    public ResponseStatusMessage createResponseStatusMessage() {
        return new ResponseStatusMessage();
    }

    /**
     * Create an instance of {@link InternalAccountKey }
     * 
     */
    public InternalAccountKey createInternalAccountKey() {
        return new InternalAccountKey();
    }

    /**
     * Create an instance of {@link ModifyAccountContactsRequest }
     * 
     */
    public ModifyAccountContactsRequest createModifyAccountContactsRequest() {
        return new ModifyAccountContactsRequest();
    }

    /**
     * Create an instance of {@link AccountFreeAttributes }
     * 
     */
    public AccountFreeAttributes createAccountFreeAttributes() {
        return new AccountFreeAttributes();
    }

    /**
     * Create an instance of {@link AccountAddressIdentifier }
     * 
     */
    public AccountAddressIdentifier createAccountAddressIdentifier() {
        return new AccountAddressIdentifier();
    }

    /**
     * Create an instance of {@link SimpleCurrency }
     * 
     */
    public SimpleCurrency createSimpleCurrency() {
        return new SimpleCurrency();
    }

    /**
     * Create an instance of {@link AccountPhoneNumberIdentifier }
     * 
     */
    public AccountPhoneNumberIdentifier createAccountPhoneNumberIdentifier() {
        return new AccountPhoneNumberIdentifier();
    }

    /**
     * Create an instance of {@link ExternalFormatAccount }
     * 
     */
    public ExternalFormatAccount createExternalFormatAccount() {
        return new ExternalFormatAccount();
    }

    /**
     * Create an instance of {@link CreateAccountRequest }
     * 
     */
    public CreateAccountRequest createCreateAccountRequest() {
        return new CreateAccountRequest();
    }

    /**
     * Create an instance of {@link AccountEmailAddress }
     * 
     */
    public AccountEmailAddress createAccountEmailAddress() {
        return new AccountEmailAddress();
    }

    /**
     * Create an instance of {@link AccountEmailAddresses }
     * 
     */
    public AccountEmailAddresses createAccountEmailAddresses() {
        return new AccountEmailAddresses();
    }

    /**
     * Create an instance of {@link CreateAccountResponse }
     * 
     */
    public CreateAccountResponse createCreateAccountResponse() {
        return new CreateAccountResponse();
    }

    /**
     * Create an instance of {@link AccountIdentifierOurBranch }
     * 
     */
    public AccountIdentifierOurBranch createAccountIdentifierOurBranch() {
        return new AccountIdentifierOurBranch();
    }

    /**
     * Create an instance of {@link RestrictedAccount }
     * 
     */
    public RestrictedAccount createRestrictedAccount() {
        return new RestrictedAccount();
    }

    /**
     * Create an instance of {@link AccountAddress }
     * 
     */
    public AccountAddress createAccountAddress() {
        return new AccountAddress();
    }

    /**
     * Create an instance of {@link AccountUseAnExistingAddress }
     * 
     */
    public AccountUseAnExistingAddress createAccountUseAnExistingAddress() {
        return new AccountUseAnExistingAddress();
    }

    /**
     * Create an instance of {@link InternalFormatAccountOurBranch }
     * 
     */
    public InternalFormatAccountOurBranch createInternalFormatAccountOurBranch() {
        return new InternalFormatAccountOurBranch();
    }

    /**
     * Create an instance of {@link AccountEmailAddressIdentifier }
     * 
     */
    public AccountEmailAddressIdentifier createAccountEmailAddressIdentifier() {
        return new AccountEmailAddressIdentifier();
    }

    /**
     * Create an instance of {@link AccountFreeAttribute }
     * 
     */
    public AccountFreeAttribute createAccountFreeAttribute() {
        return new AccountFreeAttribute();
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResponseFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soprabanking.com/amplitude", name = "errorResponseFlow")
    public JAXBElement<ErrorResponseFlow> createErrorResponseFlow(ErrorResponseFlow value) {
        return new JAXBElement<ErrorResponseFlow>(_ErrorResponseFlow_QNAME, ErrorResponseFlow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusRequestFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soprabanking.com/amplitude", name = "getStatusRequestFlow")
    public JAXBElement<GetStatusRequestFlow> createGetStatusRequestFlow(GetStatusRequestFlow value) {
        return new JAXBElement<GetStatusRequestFlow>(_GetStatusRequestFlow_QNAME, GetStatusRequestFlow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAccountRequestFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soprabanking.com/amplitude", name = "createAccountRequestFlow")
    public JAXBElement<CreateAccountRequestFlow> createCreateAccountRequestFlow(CreateAccountRequestFlow value) {
        return new JAXBElement<CreateAccountRequestFlow>(_CreateAccountRequestFlow_QNAME, CreateAccountRequestFlow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusResponseFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soprabanking.com/amplitude", name = "getStatusResponseFlow")
    public JAXBElement<GetStatusResponseFlow> createGetStatusResponseFlow(GetStatusResponseFlow value) {
        return new JAXBElement<GetStatusResponseFlow>(_GetStatusResponseFlow_QNAME, GetStatusResponseFlow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAccountResponseFlow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soprabanking.com/amplitude", name = "createAccountResponseFlow")
    public JAXBElement<CreateAccountResponseFlow> createCreateAccountResponseFlow(CreateAccountResponseFlow value) {
        return new JAXBElement<CreateAccountResponseFlow>(_CreateAccountResponseFlow_QNAME, CreateAccountResponseFlow.class, null, value);
    }

}
