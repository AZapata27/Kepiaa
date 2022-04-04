package co.gov.banrep.kepiaa.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Se excluyen la autoconfiguracion de las datasource ya que este modulo no necesita conexion a BD
 */
@SpringBootApplication(scanBasePackages  ="co.gov.banrep.kepiaa",exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
public class KepiaaMenuAplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KepiaaMenuAplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(KepiaaMenuAplication.class, args);
	}


}