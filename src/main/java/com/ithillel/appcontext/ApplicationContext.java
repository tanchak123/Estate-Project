package com.ithillel.appcontext;

import com.ithillel.dao.interfaces.AreaDao;
import com.ithillel.dao.interfaces.RegionDao;
import com.ithillel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.*;

@Configuration
@ImportResource("classpath:springCfg.xml")
@ComponentScan({"com.ithillel.service",
        "com.ithillel.dao"})
@PropertySources({
        @PropertySource("classpath:postgre.props"),
        @PropertySource("classpath:hibernate.props")})
@EnableTransactionManagement
public class ApplicationContext {

    @Autowired
    Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory
                = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.ithillel.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        Properties props = new Properties();
        System.out.println(env.getProperty("hibernate.dialect"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("show_sql", env.getProperty("show_sql"));
        entityManagerFactory.setJpaProperties(props);
        return entityManagerFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("user"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationContext.class);
//        ClassPathXmlApplicationContext applicationContext
//                = new ClassPathXmlApplicationContext("classpath:springCfg.xml");
//        System.out.println(annotationConfigApplicationContext.getBean("dataSource").toString());
        RegionDao regionDao = (RegionDao) annotationConfigApplicationContext.getBean("regionDaoImpl");
        AreaDao oblastDao = (AreaDao) annotationConfigApplicationContext.getBean("areaDaoImpl");
//        Region region = new Region();
//        region.setName("Одесса");
//        Area oblast = new Area();
//        oblast.setDistricts(new ArrayList<>());
//        oblast.setName("Одесская обл.");
//        oblast.setRegion(region);
//        region.setArea(oblast);
//
//        District district = new District();
//        district.setName("Суворовский");
//        district.setOblast(oblast);
//        oblast.getDistricts().add(district);
//        district = new District();
//        district.setOblast(oblast);
//        district.setName("Лиманский");
//        oblast.getDistricts().add(district);
//
//        City city = new City();
//        city.setName("Южный");
//        city.setDistrict(district);
//        district.setCities(new ArrayList<>(List.of(city)));
//
//        EstateAgency estateAgency1 = new EstateAgency();
//        estateAgency1.setName("Радуга");
//        estateAgency1.setDistrict(district);
//
//        EstateAgency estateAgency2 = new EstateAgency();
//        estateAgency2.setName("Зло");
//        estateAgency2.setDistrict(district);
//        district.setEstateAgency(new ArrayList<>(List.of(estateAgency1, estateAgency2)));
//
//        Realtor realtor1 = new Realtor();
//        realtor1.setName("Александр");
//        realtor1.setEstateAgency(new ArrayList<>(List.of(estateAgency1, estateAgency2)));
//
//        Realtor realtor2 = new Realtor();
//        realtor2.setName("Василий");
//        realtor2.setEstateAgency(new ArrayList<>(Collections.singletonList(estateAgency1)));
//        estateAgency1.setRealtorList(new ArrayList<>(List.of(realtor1, realtor2)));
//        estateAgency2.setRealtorList(new ArrayList<>(List.of(realtor2)));
//
//        RealProperty realProperty2 = new RealProperty();
//        realProperty2.setName("Универмаг");
//        realProperty2.setRealtors(new ArrayList<>(List.of(realtor2)));
//        realtor2.setPropertyList(List.of(realProperty2));
//
//        RealProperty realProperty1 = new RealProperty();
//        realProperty1.setName("Дом");
//        realProperty1.setRealtors(new ArrayList<>(List.of(realtor1)));
//        realtor1.setPropertyList(List.of(realProperty1));
//
//        regionDao.add(region);

        regionDao.getAll().forEach(region -> System.out.println(region.getName()));
        Region x = regionDao.get(1L);
        System.out.println(x);
        x.setName("Одесса");
        regionDao.update(x);
        Area x1 = oblastDao.get(1L);
        System.out.println(x1.getDistricts().size());
    }
}
