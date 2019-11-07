
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _ValidateEmailAddressResponse_QNAME = new QName("http://service/", "validateEmailAddressResponse");
    private final static QName _SendEmailBatch_QNAME = new QName("http://service/", "sendEmailBatch");
    private final static QName _SendEmailBatchResponse_QNAME = new QName("http://service/", "sendEmailBatchResponse");
    private final static QName _ValidateEmailAddress_QNAME = new QName("http://service/", "validateEmailAddress");
    private final static QName _SendMail_QNAME = new QName("http://service/", "sendMail");
    private final static QName _SendMailResponse_QNAME = new QName("http://service/", "sendMailResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateEmailAddressResponse }
     * 
     */
    public ValidateEmailAddressResponse createValidateEmailAddressResponse() {
        return new ValidateEmailAddressResponse();
    }

    /**
     * Create an instance of {@link SendMail }
     * 
     */
    public SendMail createSendMail() {
        return new SendMail();
    }

    /**
     * Create an instance of {@link SendMailResponse }
     * 
     */
    public SendMailResponse createSendMailResponse() {
        return new SendMailResponse();
    }

    /**
     * Create an instance of {@link ValidateEmailAddress }
     * 
     */
    public ValidateEmailAddress createValidateEmailAddress() {
        return new ValidateEmailAddress();
    }

    /**
     * Create an instance of {@link SendEmailBatchResponse }
     * 
     */
    public SendEmailBatchResponse createSendEmailBatchResponse() {
        return new SendEmailBatchResponse();
    }

    /**
     * Create an instance of {@link SendEmailBatch }
     * 
     */
    public SendEmailBatch createSendEmailBatch() {
        return new SendEmailBatch();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateEmailAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "validateEmailAddressResponse")
    public JAXBElement<ValidateEmailAddressResponse> createValidateEmailAddressResponse(ValidateEmailAddressResponse value) {
        return new JAXBElement<ValidateEmailAddressResponse>(_ValidateEmailAddressResponse_QNAME, ValidateEmailAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendEmailBatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "sendEmailBatch")
    public JAXBElement<SendEmailBatch> createSendEmailBatch(SendEmailBatch value) {
        return new JAXBElement<SendEmailBatch>(_SendEmailBatch_QNAME, SendEmailBatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendEmailBatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "sendEmailBatchResponse")
    public JAXBElement<SendEmailBatchResponse> createSendEmailBatchResponse(SendEmailBatchResponse value) {
        return new JAXBElement<SendEmailBatchResponse>(_SendEmailBatchResponse_QNAME, SendEmailBatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateEmailAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "validateEmailAddress")
    public JAXBElement<ValidateEmailAddress> createValidateEmailAddress(ValidateEmailAddress value) {
        return new JAXBElement<ValidateEmailAddress>(_ValidateEmailAddress_QNAME, ValidateEmailAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "sendMail")
    public JAXBElement<SendMail> createSendMail(SendMail value) {
        return new JAXBElement<SendMail>(_SendMail_QNAME, SendMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "sendMailResponse")
    public JAXBElement<SendMailResponse> createSendMailResponse(SendMailResponse value) {
        return new JAXBElement<SendMailResponse>(_SendMailResponse_QNAME, SendMailResponse.class, null, value);
    }

}
