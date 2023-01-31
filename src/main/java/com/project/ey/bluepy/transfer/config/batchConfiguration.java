package com.project.ey.bluepy.transfer.config;

import com.project.ey.bluepy.transfer.batch.item.procesor.TransferProcessor;
import com.project.ey.bluepy.transfer.batch.item.reader.TransferReader;
import com.project.ey.bluepy.transfer.batch.item.writer.TransferWriter;
import com.project.ey.bluepy.transfer.batch.listener.JobListener;
import com.project.ey.bluepy.transfer.entities.Transfer;
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
    public Job ExportTransferJob(JobListener listener, Step step1) {
        return jobBuilderFactory.get("exportTransferJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public TransferReader reader(){
        return new TransferReader();
    }

    @Bean
    public TransferProcessor processor(){
        return  new TransferProcessor();
    }

    @Bean
    public TransferWriter writer(){
        return new TransferWriter();
    }
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Transfer, Transfer> chunk(5) // procesa en bloques de 5
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
