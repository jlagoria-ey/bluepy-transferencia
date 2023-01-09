package com.project.ey.bluepy.transfer.batch.task;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobTask {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(fixedRate = 10000)
    public void executeJob() throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("jobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job,jobParameters);
    }
}
