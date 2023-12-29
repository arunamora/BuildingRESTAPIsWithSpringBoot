package com.example.aruna.buildingrestapiswithspringboot.controller;


// Simply by writing Controller at the end of the class name, the class doesn't become the controller.
// We need to annotate with @Controller for the class to be simply controller but specifically if we want it to
// be a rest controller we use @RestController. Controllers are thin and dumb, they are not supposed to do a lot.
// They are supposed to take requests and return responses

import com.example.aruna.buildingrestapiswithspringboot.model.LiveStream;
import com.example.aruna.buildingrestapiswithspringboot.repository.LiveStreamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@ResponseBody annotation says that the @ResponseBody annotated method should return the value that is bound to
// the web response body. Here we are going to return json body.


//Step : 1
@RestController
//Step : 2
@RequestMapping("/streams") //path for uniform resource to build APIs that focus on a resource and here in this
// case we are working with live stream too many times.

// when we are talking about REST APIs we are working with a single resource which could be in charge of other
// resources. Here we are working with a single resource called streams
public class LiveStreamController {

    //Step: 4

   /* LiveStreamRepository repository;

    public LiveStreamController() {
        repository = new LiveStreamRepository();
    }
    /* this is not the way as when the default constructor changes, the instance of LiveStreamRepository
    must also be updated everywhere in the project. It will also become difficult to write test cases
     For this Dependency injection is used.*/


    /*Dependency injection or inversion of control is where we won't be held responsible for creating the
    instances of LiveStreamRepository rather that would be the responsibility of the framework on our behalf.
    Dependency injection is going to solve a lot of problems for us. Below is the way to refactor the same*/

    //Step : 5

    /*no need of using @Autowired annotation for dependency injection in the Spring versions after Spring4.3,
    it is by default understood when spring  sees a single constructor with single parameter passed. It will
    go further and will create for us*/
    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }


//Step : 0
    /*// to get some data to our application we are going to generate a constructor
    public List<LiveStream> streams = new ArrayList<>();

    //Here we are violating the logic of controller and trying to manage some of the data. for this reason
    // we will be writing the logic elsewhere in repository
    public LiveStreamController() {
        streams.add(new LiveStream());
    }*/

    //Step : 3

    //GET http://localhost:8080/streams
    @GetMapping // here for this get request method am not giving any path, as i have already given the
    // path to the mehod in which it is present. Since the path is same no need to specify separately.
    public List<LiveStream> findAll(){
        //return null;
        //Step : 6
        return repository.findAll();
    }


    //GET http://localhost:8080/streams/1242-45875-4575-25886
    @GetMapping("/{id}") //{} is the dynamic placeholder of an id
    //we can pull that placeholder out by using a path variable which says that the argument that is created String
    // id, please go ahead and pull that out of the path for me
    public LiveStream findById(@PathVariable String id){
        return repository.findById(id);
    }

    //POST http://localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@Valid @RequestBody LiveStream stream){ // converting json into LiveStream instance
        return repository.create(stream);
    }


    //PUT  http://localhost:8080/streams/1242-45875-4575-25886
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public LiveStream update(@RequestBody LiveStream stream, @PathVariable String id){
        return repository.update(stream, id);
    }

    //DELETE  http://localhost:8080/streams/1242-45875-4575-25886
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }
}
