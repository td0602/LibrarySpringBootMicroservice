package ms.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@SpringBootApplication
public class NotificationserviceApplication {

	@Bean
	public Consumer<String> trandoan() {
		return message -> System.out.println("Message: "  + message);
//		Nếu hàm xử lý phức tạp thì viết là:
//		return message -> {
//			System.out.println("Message 1: "  + message);
//			System.out.println("Message 2: "  + message);
//		};
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationserviceApplication.class, args);
	}
}
