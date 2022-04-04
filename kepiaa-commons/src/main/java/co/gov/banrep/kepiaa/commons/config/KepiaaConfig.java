package co.gov.banrep.kepiaa.commons.config;

import co.gov.banrep.kepiaa.commons.enums.ProfileEnum;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import co.com.itac.s3.agente.web.FiltroAM;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Clase en la cual se centraliza toda la configuracion personalizada de la aplicacion
 */
@Configuration
public class KepiaaConfig {

    private static final String DATEFORMAT = "dd/MM/yyyy";
    private static final String DATETIMEFORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final Locale LOCALE = new Locale("es","CO");
    private static final TimeZone TIMEZONE = TimeZone.getTimeZone("America/Bogota");

    /**
     * Bean encargado de setear formato estandar de serializacion y deserializacion
     * para todas las request y response del aplicativo
     *
     * @see <a href="https://www.baeldung.com/jackson">Documentation https://www.baeldung.com/jackson</a>
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(DATETIMEFORMAT);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATEFORMAT,LOCALE)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIMEFORMAT,LOCALE)));
            builder.timeZone(TIMEZONE);
            builder.locale(LOCALE);
            builder.deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATEFORMAT,LOCALE)));
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATETIMEFORMAT,LOCALE)));
        };
    }


	/**
	 * <p>
	 * Bean encargado de registrar el UNICO y PRINCIPAL filtro de seguridad S3 para todas las request
     * Se registra solo para los perfiles "dev","test","prod" para que el desarrollador en perfil LOCAL
     * no tenga problemas con este filtro de seguridad
     *
     * IMPORTANTE este filtro de contar con un archivo de configuracion que debe estar indicado en la ruta especifica
     * de la siguiente propiedad que se encuentra en application.properties:
     *  server.servlet.context-parameters.RUTA_CONFIGURACION_S3
     *
	 * </p>
	 *
	 * @return FilterRegistrationBean
	 **/
    @Bean
    @Profile({
            ProfileEnum.DEV,
            ProfileEnum.TEST,
            ProfileEnum.PROD})
    public FilterRegistrationBean<FiltroAM> filtroS3AMBean() {
        FilterRegistrationBean<FiltroAM> filtroAM = new FilterRegistrationBean<>(new FiltroAM());
        filtroAM.setName("FiltroAM");
        filtroAM.addUrlPatterns("/*");
        return filtroAM;
    }





}
