package com.example.aruna.buildingrestapiswithspringboot.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LiveStream(
        String id,
        @NotEmpty
        String title,
        String description,
        String url,
        LocalDateTime startDate,
        LocalDateTime endDate) {
//All these arguments that we passed into this record constructor are the components, so, we can get all these
// components and to make sure they equal we are using
// "assertEquals(6,stream.getClass().getRecordComponents().length);" in LiveStreamTest.java.

    /*//Generate a canonical constructor, for this u can add validations, otherwise we can use compact constructor.
    public LiveStream(String id, String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
    }*/

    /*// Generate a compact constructor
    public LiveStream {
        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }
    }*/

    /*public boolean isLive() {
        return LocalDateTime.now().isAfter(startDate) && LocalDateTime.now().isBefore(endDate);
    }*/
}
