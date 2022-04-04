
package co.gov.banrep.kepiaa.menu.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultarMenuPerfilResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarMenuPerfilResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://banrep.gov.co/s3}respuestaConsultarMenuPerfil" minOccurs="0" form="qualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarMenuPerfilResponse", propOrder = {
    "_return"
})
public class ConsultarMenuPerfilResponse {

    @XmlElement(name = "return", namespace = "http://banrep.gov.co/s3")
    protected RespuestaConsultarMenuPerfil _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaConsultarMenuPerfil }
     *     
     */
    public RespuestaConsultarMenuPerfil getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaConsultarMenuPerfil }
     *     
     */
    public void setReturn(RespuestaConsultarMenuPerfil value) {
        this._return = value;
    }

}
