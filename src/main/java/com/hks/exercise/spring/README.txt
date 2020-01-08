SpringFactoriesLoader  加载spring.factories文件

YamlPropertySourceLoader

PropertiesLoaderUtils

Spring装配bean的过程：
    1. 使用默认构造器方法或指定构造参数进行Bean实例化；  
    2. 根据property标签的配置调用Bean实例中的相关set方法完成属性的赋值。 
    3. 如果Bean实现了BeanNameAware接口，调用setBeanName设置Bean的ID或者Name； 
    4. 如果Bean实现了BeanFactoryAware接口，调用setBeanFactory设置BeanFactory； 
    5. 如果Bean实现了ApplicationContextAware，调用setApplicationContext设置ApplicationContext；
    6. 如果有BeanPostProcessor与当前bean关联，则与之关联的对象的postProcessor-BeforeInitialzation()方法将被调用； 
    7. 调用InitializingBean的afterPropertiesSet()方法； 
    8. 调用定制init-method方法； 
    9. 调用BeanPostProcessor的后初始化方法；
-------------------------------------------------------------------------------
Spring接口，所有接口实现类都必须是注册成bean才生效.@Configuration
    1. InitializingBean 
        在bean属性设置完后调用,做bean的初始化工作，对应注解:@PostConstruct,
        也可以在@Bean注解initMethod属性指定初始化方法 
    2. DisposableBean 
        在bean生命周期结束之前调用,对应注解@PreDestroy，
        也可以在@Bean注解destroyMethod属性指定初始化方法 
    3. ApplicationContextAware 
        bean注册时注入获取ApplicationContext 
    4. EnvironmentAware bean注册时注入获取Environment, 
        用于获取各种属性(系统属性,环境变量,自定义的(yml|properties文件))或者设置Profile
    5. BeanNameAware 
        bean注册时获取该bean的名 
    6. BeanFactoryAware 
        获取加载该bean的BeanFactory 
    7. BeanClassLoaderAware 
        获取Bean自身的类加载器 
    8. FactoryBean 
        可以控制spring生成指定类型bean的结果 
    9. InstantiationAwareBeanPostProcessor 
        每个bean实例化阶段触发，
        postProcessBeforeInstantiation，postProcessAfterInstantiation 
    10. BeanPostProcessor
        每一个bean初始化前触发postProcessBeforeInitialization，
        初始化完触发postProcessAfterInitialization 
    11. BeanFactoryPostProcessor 
        beanfactory加载后执行，只执行一次,可以修改bean属性,scope等。 
    12. ResourceLoaderAware： 
        获取资源加载器,可以用于加载指定资源 
    13. ImportBeanDefinitionRegistrar 用于额外注册bean，
        该接口实现类通过使用@Import导入使用 
        接口方法：registerDefaultConfiguration（AnnotationMetadata，BeanDefinitionRegistry）
            AnnotationMetadata：使用了@Import的类型的源注解 
            BeanDefinitionRegistry：提供了BeanDefinition注册和移除的相关操作 
---------------------------------------------------------------------            
Spring注解
    @PropertySource("指定配置文件位置",支持数组指定多个配置文件) 
    获取指定配置文件中的属性 @Value("配置文件中的属性名") 
    @PostConstruct   方法注解
        bean初始化执行方法
    @PreDestroy  方法注解
        bean初始化完成后执行
    @ConditionalOnClass ： classpath中存在该类时起效 
    @ConditionalOnMissingClass ： classpath中不存在该类时起效 
    @ConditionalOnBean ： DI容器中存在该类型Bean时起效 
    @ConditionalOnMissingBean ： DI容器中不存在该类型Bean时起效 
    @ConditionalOnSingleCandidate ： DI容器中该类型Bean只有一个或@Primary的只有一个时起效 
    @ConditionalOnExpression ： SpEL表达式结果为true时 
    @ConditionalOnProperty ： 参数设置或者值一致时起效 
    @ConditionalOnResource ： 指定的文件存在时起效 
    @ConditionalOnJndi ： 指定的JNDI存在时起效 
    @ConditionalOnJava ： 指定的Java版本存在时起效 
    @ConditionalOnWebApplication ： Web应用环境下起效 
    @ConditionalOnNotWebApplication ： 非Web应用环境下起效
    @AutoConfigureAfter：在指定的配置类初始化后再加载 
    @AutoConfigureBefore：在指定的配置类初始化前加载 
    @AutoConfigureOrder：数越小越先初始化
---------------------------------------------------------------------        
Spring类
    ClassPathScanningCandidateComponentProvider 
    用于扫描包类，生成BeanDefinition，
    添加Filter过滤需要扫描的类 AnnotationTypeFilter：注解过滤器