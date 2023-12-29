// Repository is similar to dao pattern which is a kind of encapsulating some data acces. Here we are not going to
// talk to databases which actually complicates the things, rather we are going have an in-memory representation
// our streams, so list of live stream  is created here " List<LiveStream> streams = new ArrayList<>();" and is
// initialized to an ArrayList. And in the constructor for the repository a new stream is added which will be
// having a random UUID, descriptor, title, url, startDate and endDate. I have some methods to access them.
package com.example.aruna.buildingrestapiswithspringboot.repository;

import com.example.aruna.buildingrestapiswithspringboot.model.LiveStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository(){
        streams.add(new LiveStream(
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
                LocalDateTime.of(2023, 12, 15, 12, 38)));
    }

    public List<LiveStream> findAll(){
        return streams;
    }

    public LiveStream findById(String id){
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public LiveStream create(LiveStream stream){
        streams.add(stream);
        return stream;
    }

    public LiveStream update(LiveStream stream, String id){
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i,stream);
        return stream;
    }

    public void delete(String id){
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
