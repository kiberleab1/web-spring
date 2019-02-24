package com.hhhkk.eHotels.configurations;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig{
 
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] { "com.hhhkk.eHotels" });
 
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
 
      return em;
   }
 
   @Bean
   public DriverManagerDataSource dataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/eHotel");
      dataSource.setUsername( "ehotel" );
      dataSource.setPassword( "abeba" );
      return dataSource;
   }
 
   @Bean
   public PlatformTransactionManager transactionManager(
     EntityManagerFactory emf){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf);
 
       return transactionManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
       return new PersistenceExceptionTranslationPostProcessor();
   }
 /*
   @Bean
   Properties additionalProperties() {
       Properties properties = new Properties();
       properties.setProperty("hibernate.ddl.auto", "update");
      // properties.setProperty(
        // "spring.jpa.hibernate.naming.implicit-strategy", "org.hibernate.cfg.DefaultNamingStrategy");
       properties.setProperty(
    	         "spring.jpa.properties.hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
    	     
       return properties;
   }
*/
   }

