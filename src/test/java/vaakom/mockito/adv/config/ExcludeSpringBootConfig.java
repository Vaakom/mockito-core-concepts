package vaakom.mockito.adv.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import vaakom.mockito.MockitoCoreConceptsApplication;

@Configuration
@ComponentScan(
        basePackages = "vaakom.mockito",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MockitoCoreConceptsApplication.class)
)
public class ExcludeSpringBootConfig {
}
