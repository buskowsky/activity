//package jfonferko.genuitek.activity.config;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Created by JFonferko on 2016-08-17.
// */
//@Configuration
//@PropertySource(value = {"classpath:application.properties"})
//@EnableJpaRepositories(basePackages = "jfonferko.genuitek.activity")
//public class HibernateConfig {
//
//    @Autowired
//    Environment environment;
//
//    @Bean
//    public DataSource dataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
////        dataSource.setValidationQuery(environment.getRequiredProperty("validationQuery"));
//        return dataSource;
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory(){
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//
//        adapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setJpaVendorAdapter(adapter);
//        factoryBean.setPackagesToScan("jfonferko.genuitek.activity.domain");
//        factoryBean.setDataSource(this.dataSource());
//        factoryBean.setJpaProperties(hibernateProperties());
//        factoryBean.afterPropertiesSet();
//        return factoryBean.getObject();
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto") );
//        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql") );
//        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//        properties.put("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));
////        properties.put("hibernate.hbm2ddl.import_files", environment.getRequiredProperty("hibernate.hbm2ddl.import_files"));
//        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//        return properties;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        JpaTransactionManager txmanager = new JpaTransactionManager();
//        txmanager.setEntityManagerFactory(entityManagerFactory());
//        return txmanager;
//    }
//}