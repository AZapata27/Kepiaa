
package co.gov.banrep.kepiaa.menu.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.baeldung.soap.ws.client.generated package. 
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

    private final static QName _AdministradorMenuException_QNAME = new QName("http://banrep.gov.co/s3", "AdministradorMenuException");
    private final static QName _ConsultarMenuPerfil_QNAME = new QName("http://banrep.gov.co/s3", "consultarMenuPerfil");
    private final static QName _ConsultarMenuPerfilResponse_QNAME = new QName("http://banrep.gov.co/s3", "consultarMenuPerfilResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.baeldung.soap.ws.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdministradorMenuException }
     * 
     */
    public AdministradorMenuException createAdministradorMenuException() {
        return new AdministradorMenuException();
    }

    /**
     * Create an instance of {@link ConsultarMenuPerfil }
     * 
     */
    public ConsultarMenuPerfil createConsultarMenuPerfil() {
        return new ConsultarMenuPerfil();
    }

    /**
     * Create an instance of {@link ConsultarMenuPerfilResponse }
     * 
     */
    public ConsultarMenuPerfilResponse createConsultarMenuPerfilResponse() {
        return new ConsultarMenuPerfilResponse();
    }

    /**
     * Create an instance of {@link PeticionConsultarMenuPerfil }
     * 
     */
    public PeticionConsultarMenuPerfil createPeticionConsultarMenuPerfil() {
        return new PeticionConsultarMenuPerfil();
    }

    /**
     * Create an instance of {@link MenuRequest }
     * 
     */
    public MenuRequest createMenuRequest() {
        return new MenuRequest();
    }

    /**
     * Create an instance of {@link MensajeBase }
     * 
     */
    public MensajeBase createMensajeBase() {
        return new MensajeBase();
    }

    /**
     * Create an instance of {@link RespuestaConsultarMenuPerfil }
     * 
     */
    public RespuestaConsultarMenuPerfil createRespuestaConsultarMenuPerfil() {
        return new RespuestaConsultarMenuPerfil();
    }

    /**
     * Create an instance of {@link MenuElement }
     * 
     */
    public MenuElement createMenuElement() {
        return new MenuElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdministradorMenuException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdministradorMenuException }{@code >}
     */
    @XmlElementDecl(namespace = "http://banrep.gov.co/s3", name = "AdministradorMenuException")
    public JAXBElement<AdministradorMenuException> createAdministradorMenuException(AdministradorMenuException value) {
        return new JAXBElement<AdministradorMenuException>(_AdministradorMenuException_QNAME, AdministradorMenuException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarMenuPerfil }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarMenuPerfil }{@code >}
     */
    @XmlElementDecl(namespace = "http://banrep.gov.co/s3", name = "consultarMenuPerfil")
    public JAXBElement<ConsultarMenuPerfil> createConsultarMenuPerfil(ConsultarMenuPerfil value) {
        return new JAXBElement<ConsultarMenuPerfil>(_ConsultarMenuPerfil_QNAME, ConsultarMenuPerfil.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarMenuPerfilResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarMenuPerfilResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://banrep.gov.co/s3", name = "consultarMenuPerfilResponse")
    public JAXBElement<ConsultarMenuPerfilResponse> createConsultarMenuPerfilResponse(ConsultarMenuPerfilResponse value) {
        return new JAXBElement<ConsultarMenuPerfilResponse>(_ConsultarMenuPerfilResponse_QNAME, ConsultarMenuPerfilResponse.class, null, value);
    }

}
