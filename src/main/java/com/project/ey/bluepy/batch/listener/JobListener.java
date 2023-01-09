package com.project.ey.bluepy.batch.listener;

import com.project.ey.bluepy.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JobListener extends JobExecutionListenerSupport {

    //private static final Logger LOG = (Logger) LoggerFactory.getLogger(JobListener.class);

    @Autowired
    UserService userService;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            //LOG.info("FINALIZÓ EL JOB!! Verifica los resultados:");
            //userService.findAllUsers().forEach(user -> LOG.info(user.getName()));
        }
    }

}
