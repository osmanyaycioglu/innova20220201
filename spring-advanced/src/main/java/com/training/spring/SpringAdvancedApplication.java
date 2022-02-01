package com.training.spring;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.innova.spring.CounterBean;
import com.lib.spring.Employee;
import com.lib.spring.Printer;
import com.lib.spring.PrinterConfiguration;
import com.training.spring.di.GreetingBean;
import com.training.spring.di.RealCounter;

@SpringBootApplication(scanBasePackages = {
                                            "com.training.spring",
                                            "com.innova.spring"
})
@Import(PrinterConfiguration.class)
@EnableConfigurationProperties
@ServletComponentScan
public class SpringAdvancedApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringAdvancedApplication.class);


    private final GreetingBean gb;

    @Autowired
    @RealCounter
    private CounterBean        cb;

    @Autowired
    private Printer            print;

    @Autowired
    public SpringAdvancedApplication(final GreetingBean gb) {
        this.gb = gb;
    }

    public SpringAdvancedApplication(final GreetingBean gb,
                                     final String str) {
        this.gb = gb;
    }

    public static void main(final String[] args) {

        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringAdvancedApplication.class,
                                                                          args);

        SpringAdvancedApplication beanLoc = contextLoc.getBean(SpringAdvancedApplication.class);
        beanLoc.gb.greet("osman");
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        this.cb.increamentAndGet();
        SpringAdvancedApplication.logger.info("counter : " + this.cb.getCounter());
        this.print.print(Employee.createEmployee()
                                 .setUsername("osmany")
                                 .setName("osman")
                                 .setSurname("yaycıoğlu")
                                 .setHeight(200)
                                 .setBirthDate(LocalDate.of(1970,
                                                            9,
                                                            11)));
    }

}
