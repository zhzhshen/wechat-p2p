package Servlet;

import Resource.Global;
import api.BasicSupport;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by twer on 4/15/15.
 *
 * Get token from server every 2 hours
 */
public class AccessTokenServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(AccessTokenServlet.class);
    @Override
    public void init() throws ServletException {
        logger.debug("initializing access token servlet");
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our AccessToken class
            JobDetail job = newJob(AccessTokenJob.class)
                    .withIdentity("accessToken", "api")
                    .build();

            // Trigger the job to run now, and then repeat every 2 hours
            Trigger trigger = newTrigger()
                    .withIdentity("accessTokenTrigger", "api")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(7200)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    public static class AccessTokenJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            BasicSupport.getAccessToken(Global.APP_ID, Global.APP_SECRET);
            logger.debug("executing access token job");
        }
    }
}
