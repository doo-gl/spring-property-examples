package doo.gl.conversion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.time.ZonedDateTime;

/**
 * We need to register our new converter with the spring configuration.
 *
 * To do this, it is possible to create a bean which returns the conversion service with the
 * new converter added to it.
 */
@Configuration
public class ConversionConfiguration  {

    @Bean(name = "conversionService")
    public ConversionService createConversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new ZonedDateTimeConverter());
        return service;
    }

    public static class ZonedDateTimeConverter implements Converter<String, ZonedDateTime> {
        @Override
        public ZonedDateTime convert(String source) {
            return ZonedDateTime.parse(source);
        }
    }

}
