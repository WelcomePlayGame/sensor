package vadym.ua.sensor.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration()
public class SensorAOP {

    @Pointcut("execution(public * vadym.ua.sensor.service.*.addSensor(..)))")
    public static void addGetSensor() {}

    private final Logger logger = LoggerFactory.getLogger(SensorAOP.class);

    @Before("addGetSensor()")
    public void  beforeGetAddSensor() {
        logger.info("You want add sensor?");
        System.out.println("Done");
    }

    @AfterReturning("addGetSensor()")
    public void afterAddSenosr() {
        logger.info("Cool! You add sensor");
    }


}
