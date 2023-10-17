package africa.box.dm.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"africa.box.dm.db", "africa.box.dm.db.entities", "africa.box.dm.db.entities_param", "africa.box.dm.db.dao_param"},
        transactionManagerRef = "DmFileTM",
        entityManagerFactoryRef = "DmFileEMF"
)
public class DmDbConfig {

    private static final Logger logger = LoggerFactory.getLogger(DmDbConfig.class);

    private final Environment env;

    public DmDbConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "DmFileDataSourceProperties")
    @ConfigurationProperties("app.dm-file.datasource")
    public DataSourceProperties dmFileDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "DmFileDataSource")
    @ConfigurationProperties(prefix = "app.dm-file.datasource.configuration")
    public DataSource dmFileDataSource(@Qualifier("DmFileDataSourceProperties") DataSourceProperties dsProps) {
        logger.info("Dm file DB Details: "+dsProps.getUrl()+", username: "+dsProps.getUsername());

        DataSource datasource = dmFileDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class)
                .build();

        return  datasource;
    }

    @Bean(name = "DmFileEMF")
    public LocalContainerEntityManagerFactoryBean dmFileEMFBean(@Qualifier("DmFileDataSource") DataSource dataSource,
                                                                  EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource)
                .packages("africa.box.dm.db", "africa.box.dm.db.dao_param")
                .properties(hibernateProperties())
                .persistenceUnit("dmPu")
                .build();
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.format_sql", true);
        props.put("hibernate.show_sql", false);
        props.put("hibernate.hbm2ddl.auto","update");
        props.put("hibernate.types.print.banner", false);
        props.put("hibernate.enable_lazy_load_no_trans", true);
        return props;
    }

    @Primary
    @Bean(name = "DmFileTM")
    public PlatformTransactionManager dmFileTM(@Qualifier("DmFileEMF") EntityManagerFactory entityManagerFactory){
        JpaTransactionManager tm = new JpaTransactionManager(entityManagerFactory);
        return tm;
    }

    @Bean
    @Autowired
    public JdbcTemplate localJdbcTemplate(@Qualifier("DmFileDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
