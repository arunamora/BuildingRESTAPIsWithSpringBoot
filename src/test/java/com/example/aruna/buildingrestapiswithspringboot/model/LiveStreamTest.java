package com.example.aruna.buildingrestapiswithspringboot.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LiveStreamTest {

    @Test
    void create_new_mutable_live_stream(){
        MutableLiveStream stream = new MutableLiveStream();

        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring Boot");
        stream.setDescription("The Spring framework supports two ways of creating RESTful services:\n" +
                "\n" +
                "using MVC with ModelAndView\n" +
                "using HTTP message converters\n" +
                "The ModelAndView approach is older and much better documented, but also more verbose and " +
                "configuration heavy. It tries to shoehorn the REST paradigm into the old model, which isn’t " +
                "without problems. The Spring team understood this, and provided first-class REST support starting" +
                " with Spring 3.0.\n" +
                "\n" +
                "The new approach, based on HttpMessageConverter and annotations, is much more lightweight and " +
                "easy to implement. Configuration is minimal, and it provides sensible defaults for what we would" +
                " expect from a RESTful service.");
        stream.setUrl("https://www.twtich.tv/danvega");
        stream.setStartDate(LocalDateTime.of(2023, 12, 15, 10, 00));
        stream.setEndDate(LocalDateTime.of(2023, 12, 15, 12, 38));

        stream.setTitle("FOO Tale");

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle(), "hello");
    }

    @Test
    void create_new_immutable_live_stream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(
                UUID.randomUUID().toString(), "Building REST APIs with Spring Boot", "The Spring framework supports two ways of creating RESTful services:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"using MVC with ModelAndView\\n\" +\n" +
                "                \"using HTTP message converters\\n\" +\n" +
                "                \"The ModelAndView approach is older and much better documented, but also more verbose and \" +\n" +
                "                \"configuration heavy. It tries to shoehorn the REST paradigm into the old model, which isn’t \" +\n" +
                "                \"without problems. The Spring team understood this, and provided first-class REST support starting\" +\n" +
                "                \" with Spring 3.0.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The new approach, based on HttpMessageConverter and annotations, is much more lightweight and \" +\n" +
                "                \"easy to implement. Configuration is minimal, and it provides sensible defaults for what we would\" +\n" +
                "                \" expect from a RESTful service.", "https://www.twtich.tv/danvega",
                LocalDateTime.of(2023, 12, 15, 10, 00),
                LocalDateTime.of(2023, 12, 15, 12, 38));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle(), "Hello");
    }


    // As we created the record : LiveStream.java, whatever we have written earlier to this becomes the
    // boilerplate code. So, writing the below test method.
    @Test
    void create_new_record_live_stream(){
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(), "Building REST APIs with Spring Boot",
                "The Spring framework supports two ways of creating RESTful services:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"using MVC with ModelAndView\\n\" +\n" +
                "                \"using HTTP message converters\\n\" +\n" +
                "                \"The ModelAndView approach is older and much better documented, but also more verbose and \" +\n" +
                "                \"configuration heavy. It tries to shoehorn the REST paradigm into the old model, which isn’t \" +\n" +
                "                \"without problems. The Spring team understood this, and provided first-class REST support starting\" +\n" +
                "                \" with Spring 3.0.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The new approach, based on HttpMessageConverter and annotations, is much more lightweight and \" +\n" +
                "                \"easy to implement. Configuration is minimal, and it provides sensible defaults for what we would\" +\n" +
                "                \" expect from a RESTful service.", "https://www.twtich.tv/danvega",
                LocalDateTime.of(2023, 12, 15, 10, 00),
                LocalDateTime.of(2023, 12, 15, 12, 38));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.title(), "Hello");
        assertTrue(stream.getClass().isRecord()); //to find out whether a particular class is a record or not
        assertEquals(6,stream.getClass().getRecordComponents().length);
        //All these arguments that we passed into LiveStream.java record constructor are the components, so,
        // we can get all these components and to make sure they equal we are using
        // "assertEquals(6,stream.getClass().getRecordComponents().length);" here.

    }
}

