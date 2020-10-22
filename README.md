# Estate-Project version-1 
1. Creation \ editing \ deletion of the "Region" entity
2. Creating \ editing \ deleting the entity "area"
3. Creation \ editing \ deletion of the entity "city"
4. Creation \ editing \ deletion of the entity "district"
5. Creating \ editing \ deleting the entity "Real estate agency"
6. Creating \ editing \ deleting the Realtor entity
7. Creation \ editing \ deletion of the "Property" entity

## Description
##### First step is configure our Spring xml + java.
* Use in our springCfg.xml : 
*     <context:component-scan base-package="com.ithillel.appcontext"/>
 ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) `Or import resource on AppContext.class:` 
*     @ImportResource("classpath:springCfg.xml")
#### Second step is create connection to our db
* On this bean we should create myDataSource bean in our AppContext.class
* Add dependency commons-dbcp2 for last step.
* Let's create postgre.props.
* We should use annotation on AppContext.class 
*     @PropertySource("classpath:postgre.props")
* Don't forget create here next Object with annotation:
*     @Autowired
      Environment env;
* Now we can read info from our Environment:
*     env.getProperty("driver")
#### Third step is create hibernate cfg
* Create hibernate.props with required info (don't forget change validate to create-drop)
* We can just do like this :
*     @Bean
      public LocalSessionFactoryBean getSessionFactoryBean() {
          LocalSessionFactoryBean factoryBean
                  = new LocalSessionFactoryBean();
          factoryBean.setDataSource(getDataSource());
          Properties props = new Properties();
          props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
          props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
          props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
          factoryBean.setHibernateProperties(props);
          factoryBean.setAnnotatedClasses(User.class);
          return factoryBean;
      }
![#f03c15](https://placehold.it/15/f03c15/000000?text=+) `OR (our example) :`
* Create Bean EntityManagerFactory (LocalContainerEntityManagerFactoryBean)
* Create Bean transactionManager (JpaTransactionManager(emf))

#### Third step it's creation of our model
* Create package com.ithillel.model.
* Create model class CustomModel with the name, dataCreated, and id field and anno:
*     @MappedSuperclass
* Create Region class with required fields and extends it from CustomModel.
* Now we should mark new sequnce :
*     @SequenceGenerator(name = "seq_name", sequenceName = "seq_client", allocationSize = 1)
      public class Region extends CustomModel {
* Let's create our entities and add OneToOne and ManyToOne connections.
* For ManyOneMany target we should use this: 
*     @ManyToMany(cascade = CascadeType.ALL)
               @JoinTable(
                       name = "EstateAgency_Realtor",
                       joinColumns = {
                               @JoinColumn(name = "estateAgency_id"),
                       },
                       inverseJoinColumns = {@JoinColumn(name = "realtor_id")}
               )
               private List<Realtor> realtorList;
* Create a file ddl.sql for our 'create tables' sql query.
