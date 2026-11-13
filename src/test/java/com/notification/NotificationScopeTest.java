package com.notification;

import com.notification.config.GatewayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NotificationScopeTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void testSingletonVsPrototypeScopes() {
        // Verify Singleton Scope: Both requests return the exact same instance reference
        GatewayConfig.EmailGatewaySimulator client1 = context.getBean(GatewayConfig.EmailGatewaySimulator.class);
        GatewayConfig.EmailGatewaySimulator client2 = context.getBean(GatewayConfig.EmailGatewaySimulator.class);
        assertThat(client1).isSameAs(client2);

        // Verify Prototype Scope: Requests return distinct instance references with unique IDs
        GatewayConfig.NotificationTracker tracker1 = context.getBean(GatewayConfig.NotificationTracker.class);
        GatewayConfig.NotificationTracker tracker2 = context.getBean(GatewayConfig.NotificationTracker.class);
        assertThat(tracker1).isNotSameAs(tracker2);
        assertThat(tracker1.getInstanceId()).isNotEqualTo(tracker2.getInstanceId());
    }
}