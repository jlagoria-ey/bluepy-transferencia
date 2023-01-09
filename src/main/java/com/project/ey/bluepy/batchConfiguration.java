package com.project.ey.bluepy;

import com.project.ey.bluepy.batch.item.UserWriter;
import com.project.ey.bluepy.batch.item.procesor.UserProcessor;
import com.project.ey.bluepy.batch.item.reader.RESTUserReader;
import com.project.ey.bluepy.batch.listener.JobListener;
import com.project.ey.bluepy.dtos.UserDTO;
import com.project.ey.bluepy.entities.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class batchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public RESTUserReader reader(){
        return new RESTUserReader();
    }

    @Bean
    public UserProcessor processor() {
        return new UserProcessor();
    }

    @Bean
    public UserWriter writer(){
        return  new UserWriter();
    }

    @Bean
    public Job ImportUserJob(JobListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<UserDTO, User> chunk(5) // procesa en bloques de 5
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
