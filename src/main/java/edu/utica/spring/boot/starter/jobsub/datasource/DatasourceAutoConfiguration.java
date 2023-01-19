package edu.utica.spring.boot.starter.jobsub.datasource;

import com.sct.messaging.bif.BatchResourceHolder;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.Connection;

@AutoConfiguration
@ConditionalOnClass({SingleConnectionDataSource.class,Connection.class,BatchResourceHolder.class})
public class DatasourceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    SingleConnectionDataSource getDataSource() {
        return new SingleConnectionDataSource(BatchResourceHolder.getConnection(),true);
    }

    @Bean
    @ConditionalOnMissingBean
    Connection getConnection() {
        return BatchResourceHolder.getConnection();
    }

}
