package africa.box.dm.config;

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

//@Configuration
//@EnableJpaRepositories(
//        basePackages = {"africa.box.dm.db.domain.filestorage"},
//        transactionManagerRef = "fileStorageTM",
//        entityManagerFactoryRef = "fileStorageMF"
//)
public class FileStorageDbConfig {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageDbConfig.class);

    private final Environment env;

    public FileStorageDbConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "fileStorageDataSourceProperties")
    @ConfigurationProperties("app.file-storage.datasource")
    public DataSourceProperties fileStorageDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "fileStorageDataSource")
    @ConfigurationProperties(prefix = "app.file-storage.datasource.configuration")
    public DataSource fileStorageDataSource(@Qualifier("fileStorageDataSourceProperties") DataSourceProperties dsProps) {
        logger.info("Dm file DB Details: "+dsProps.getUrl()+", username: "+dsProps.getUsername());

        DataSource datasource = fileStorageDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class)
                .build();

        return  datasource;
    }

    @Bean(name = "fileStorageEMF")
    public LocalContainerEntityManagerFactoryBean fileStorageEMFBean(@Qualifier("fileStorageDataSource") DataSource dataSource,
                                                                  EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource)
                .packages("africa.box.dm.db.domain")
                .properties(hibernateProperties())
                .persistenceUnit("fileStoragePu")
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


    @Bean
    @Qualifier("fileStorageTM")
    public PlatformTransactionManager fileStorageFileTM(@Qualifier("fileStorageEMF") EntityManagerFactory entityManagerFactory){
        JpaTransactionManager tm = new JpaTransactionManager(entityManagerFactory);
        return tm;
    }

    @Bean(name = "fileStorageJdbc")
    public JdbcTemplate localJdbcTemplate(@Qualifier("fileStorageDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
