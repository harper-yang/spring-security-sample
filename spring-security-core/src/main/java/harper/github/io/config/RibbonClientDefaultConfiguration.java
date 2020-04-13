package harper.github.io.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClients(defaultConfiguration = RibbonClientDefaultConfiguration.DefaultRibbonConfig.class)
public class RibbonClientDefaultConfiguration {

    public static class BazServiceList extends ConfigurationBasedServerList {

        public BazServiceList(IClientConfig config) {
            super.initWithNiwsConfig(config);
        }

    }

    @Configuration(proxyBeanMethods = false)
    class DefaultRibbonConfig {

        @Bean
        public IRule ribbonRule() {
            return new BestAvailableRule();
        }

        @Bean
        public IPing ribbonPing() {
            return new PingUrl();
        }

        @Bean
        public ServerList<Server> ribbonServerList(IClientConfig config) {
            return new RibbonClientDefaultConfiguration.BazServiceList(config);
        }

        @Bean
        public ServerListSubsetFilter serverListFilter() {
            ServerListSubsetFilter filter = new ServerListSubsetFilter();
            return filter;
        }

        @Bean
        public IClientConfig ribbonClientConfig() {
            return new DefaultClientConfigImpl();
        }

    }
}
