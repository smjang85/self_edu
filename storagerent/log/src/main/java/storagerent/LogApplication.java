package storagerent;
import storagerent.config.kafka.KafkaProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class LogApplication {
    protected static ApplicationContext applicationContext;

    @Autowired
    LogRepository logRepository;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(LogApplication.class, args);
    }
}
