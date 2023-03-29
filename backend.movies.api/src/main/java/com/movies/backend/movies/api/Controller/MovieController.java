package com.movies.backend.movies.api.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.backend.movies.api.Repository.MovieRepository;


@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseBody
    public String requestMovies() throws JsonProcessingException {
        HashMap<String, Object> res = new HashMap<>();
        res.put("Number of movies", movieRepository.count());
        res.put("Movies", movieRepository.findAll());
        return new ObjectMapper().writeValueAsString(res);
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public HttpStatus requestCheck(){
        return HttpStatus.OK;
    }
    
    @RequestMapping(value="/sql", method=RequestMethod.GET)
    @ResponseBody
    public String testCheck(){
        DBCC dbcc = new DBCC();
        dbcc.sqlController();
        return "Executed";
    }
    


}
