package com.ithillel.appcontext;

import com.ithillel.model.*;
import com.ithillel.model.description.CustomDescription;
import com.ithillel.service.interfaces.AreaService;
import com.ithillel.service.interfaces.RealPropertyService;
import com.ithillel.service.interfaces.RealtorService;
import com.ithillel.service.interfaces.RegionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:springCfg.xml")
@ComponentScan(value = {"com.ithillel.service",
        "com.ithillel.dao",
        "com.ithillel.model"})
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
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
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
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationContext.class);
        /*        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("classpath:springCfg.xml");
        System.out.println(annotationConfigApplicationContext.getBean("dataSource").toString());*/
//        RegionService regionService = (RegionService)
//                annotationConfigApplicationContext.getBean("regionServiceImpl");
//                AreaService areaService = (AreaService)
//        annotationConfigApplicationContext.getBean("areaServiceImpl");
//
//        Region service.region = new Region();
//        service.region.setName("Одесса");
//        Area oblast = new Area();
//        oblast.setDistricts(new ArrayList<>());
//        oblast.setName("Одесская обл.");
//        oblast.setRegion(service.region);
//        service.region.setArea(oblast);
//
////        CustomDescription customDescription = new CustomDescription();
////        customDescription.setDescription("fsdafdas");
////        service.region.setDescription(customDescription);
//
//        District district = new District();
//        district.setName("Суворовский");
//        district.setArea(oblast);
//        oblast.getDistricts().add(district);
//        district = new District();
//        district.setArea(oblast);
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
//        realtor1.setSurName("Ауфыв");
//        realtor1.setEstateAgency(new ArrayList<>(List.of(estateAgency1, estateAgency2)));
//
//        Realtor realtor2 = new Realtor();
//        realtor2.setName("Василий");
//        realtor2.setSurName("Михайлык");
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
//        regionService.create(service.region);
//
//        regionService.getAll().forEach(region1 -> System.out.println(region1.getName()));
//
//        Region updated = regionService.getById(26L);
//        updated.setName("UPDATED");
//        regionService.update(updated);

//        RealPropertyService realPropertyService = (RealPropertyService) annotationConfigApplicationContext
//                .getBean("realPropertyServiceImpl");
//        RealProperty realProperty = realPropertyService.getById(60L);
//        realPropertyService.delete(realProperty);
        RealtorService realtorService = (RealtorService) annotationConfigApplicationContext
                .getBean("realtorServiceImpl");
        realtorService.delete(realtorService.getById(69L));
//        Region byId = service.region(Service.getById(5L);
//        byId.setName("TESTa");
//        regionService.update(byId);
//        regionService.delete(byId);

        /*        Area x1 = areaService.get(1L);
        System.out.println(x1.getDistricts().size());*/
    }
}
