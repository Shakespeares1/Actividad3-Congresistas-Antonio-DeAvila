package co.edu.udec.congresistas.infrastructure.config;

import co.edu.udec.congresistas.application.services.CongresistaService;
import co.edu.udec.congresistas.domain.ports.inbound.CongresistaServicePort;
import co.edu.udec.congresistas.domain.ports.outbound.CongresistaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CongresistaServicePort congresistaService(CongresistaRepositoryPort repoPort) {
        return new CongresistaService(repoPort);
    }
}
