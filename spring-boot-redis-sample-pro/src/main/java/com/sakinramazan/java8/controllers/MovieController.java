package com.sakinramazan.java8.controllers;

import com.sakinramazan.java8.models.Movie;
import com.sakinramazan.java8.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    @Autowired
    IMovieService movieService;

    @GetMapping(value = "/")
    public String movies(ModelMap modelMap, @RequestParam(value = "id", required = false) Long id) {

        long start = System.currentTimeMillis();
        if (id != null) {
            modelMap.addAttribute("movie", movieService.findOne(id));
        }

        modelMap.addAttribute("movies", movieService.findAll());
        modelMap.addAttribute("speed", (System.currentTimeMillis() - start) / 1000.0);

        return "movies";
    }

    @PostMapping(value = "/")
    public String createNewOne(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "director", required = true) String director) {

        if (name != null && name.length() != 0
                && director != null && director.length() != 0) {

            Movie movie = new Movie();
            movie.setName(name);
            movie.setDirector(director);
            movieService.newOne(movie);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/movie/edit/")
    public String editOne(@RequestParam Long id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "director") String director) {

        Movie movie = movieService.findOne(id);
        if (movie != null) {
            movie.setName(name);
            movie.setDirector(director);
            movieService.newOne(movie);
        } else {
            System.out.println("There is no movie have such an id : " + id);
        }

        return "redirect:/";
    }
}