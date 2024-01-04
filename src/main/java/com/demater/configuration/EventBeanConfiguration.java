package com.demater.configuration;

import com.demater.infrastructure.events.publisher.*;
import com.demater.infrastructure.events.publisher.AuthEventPublisherAdapter;
import com.demater.infrastructure.events.publisher.CityEventPublisherAdapter;
import com.demater.infrastructure.events.publisher.GadgetEventPublisherAdapter;
import com.demater.infrastructure.events.publisher.PositionEventPublisherAdapter;
import com.demater.infrastructure.events.publisher.RoleEventPublisherAdapter;
import com.demater.infrastructure.events.publisher.StationEventPublisherAdapter;
import com.demater.infrastructure.events.publisher.UserEventPublisherAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBeanConfiguration {
    @Bean
    AccountEventPublisherAdapter accountEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new AccountEventPublisherAdapter(eventPublisher);
    }
    @Bean
    AuthEventPublisherAdapter authEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new AuthEventPublisherAdapter(eventPublisher);
    }
    @Bean
    UserEventPublisherAdapter userEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new UserEventPublisherAdapter(eventPublisher);
    }
    @Bean
    PositionEventPublisherAdapter positionEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new PositionEventPublisherAdapter(eventPublisher);
    }
    @Bean
    RoleEventPublisherAdapter roleEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new RoleEventPublisherAdapter(eventPublisher);
    }
    @Bean
    StationEventPublisherAdapter stationEventPublisher(ApplicationEventPublisher eventPublisher) {
        return new StationEventPublisherAdapter(eventPublisher);
    }
    @Bean
    CityEventPublisherAdapter cityEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new CityEventPublisherAdapter(eventPublisher);
    }
    @Bean
    GadgetEventPublisherAdapter gadgetEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
        return new GadgetEventPublisherAdapter(eventPublisher);
    }
}
