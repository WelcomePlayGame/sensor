package vadym.ua.sensor.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MeasurAOP {

    @Pointcut("execution(public * vadym.ua.sensor.service.*.add*(..)))")
    public void allGetMeasur() {};

    private final  Logger LOGGER = LoggerFactory.getLogger(MeasurAOP.class);


    @Before("allGetMeasur()")
    public void beforeAddSensor() {
        LOGGER.info("You want add measur?");
    }

    @AfterReturning("allGetMeasur()")
    public void afterAddSensor() {
        LOGGER.info("Add measur");
    }
}

