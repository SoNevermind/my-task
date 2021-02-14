package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class LoanApplicationContext {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:process-engine;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SpringProcessEngineConfiguration engineConfiguration(DataSource dataSource, PlatformTransactionManager transactionManager, @Value("classpath*:*.bpmn") Resource[] deploymentResources) {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();

        configuration.setProcessEngineName("engine");
        configuration.setDataSource(dataSource);
        configuration.setTransactionManager(transactionManager);
        configuration.setDatabaseSchemaUpdate("true");
        configuration.setJobExecutorActivate(false);
        configuration.setDeploymentResources((org.springframework.core.io.Resource[]) deploymentResources);

        return configuration;
    }

    @Bean
    public ProcessEngineFactoryBean engineFactory(SpringProcessEngineConfiguration engineConfiguration) {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(engineConfiguration);
        return factoryBean;
    }

    @Bean
    public ProcessEngine processEngine(ProcessEngineFactoryBean factoryBean) throws Exception {
        return factoryBean.getObject();
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService taskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }

    @Bean
    public HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    @Bean
    public ManagementService managementService(ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }

    @Bean
    public Starter starter(){
        return new Starter();
    }

    @Bean
    public CalculateInterestService calculateInterestService(){
        return new CalculateInterestService();
    }
}
