package africa.box.dm.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProcessEngineDbConfig {

    private static final Logger logger = LoggerFactory.getLogger(ProcessEngineDbConfig.class);

    private final Environment env;

    public ProcessEngineDbConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.process-engine.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ProcessEngineDataSource")
    @Primary
    @ConfigurationProperties(prefix = "app.process-engine.datasource")
    public HikariDataSource primaryDataSource() {
//        logger.info("Process engine DB Details: "+dsProps.getUrl()+", username: "+dsProps.getUsername());
        return primaryDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "ProcessEngineEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean processEngineEMF(@Qualifier("ProcessEngineDataSource") DataSource dataSource,
                                                                   EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource)
                .packages("org.camunda.bpm")
                .properties(hibernateProperties())
                //.persistenceUnit("pepu")
                .build();
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.format_sql", true);
        props.put("hibernate.show_sql", false);
        props.put("hibernate.hbm2ddl.auto","update");
        return props;
    }
}
