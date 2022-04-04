
package co.gov.banrep.kepiaa.menu.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuestaConsultarMenuPerfil complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuestaConsultarMenuPerfil"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://banrep.gov.co/s3}mensajeBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="menu" type="{http://banrep.gov.co/s3}menuElement" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaConsultarMenuPerfil", propOrder = {
    "menu"
})
public class RespuestaConsultarMenuPerfil
    extends MensajeBase
{

    protected MenuElement menu;

    /**
     * Obtiene el valor de la propiedad menu.
     * 
     * @return
     *     possible object is
     *     {@link MenuElement }
     *     
     */
    public MenuElement getMenu() {
        return menu;
    }

    /**
     * Define el valor de la propiedad menu.
     * 
     * @param value
     *     allowed object is
     *     {@link MenuElement }
     *     
     */
    public void setMenu(MenuElement value) {
        this.menu = value;
    }

}
