package trabalho.dwa.eventorganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "trabalho.dwa.eventorganizer")
@EntityScan(basePackages = "trabalho.dwa.eventorganizer")
public class EventOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventOrganizerApplication.class, args);
	}

}
