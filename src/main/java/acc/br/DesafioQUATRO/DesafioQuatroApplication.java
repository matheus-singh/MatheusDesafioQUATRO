package acc.br.DesafioQUATRO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioQuatroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioQuatroApplication.class, args);
	}

}
