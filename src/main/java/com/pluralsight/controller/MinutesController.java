package com.pluralsight.controller;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.model.Goal;
import com.pluralsight.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MinutesController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
    public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise,
                             BindingResult result, HttpSession session) {

        System.out.println("exercise: " + exercise.getMinutes());
        System.out.println("exercise activity: " + exercise.getActivity());

        System.out.println(exercise.getActivity() == null);
        System.out.println(exercise.getActivity());
        System.out.println("exercise above");

        if (result.hasErrors()) {
            System.out.println("exercise has errors");
            return "addMinutes";
        }
        else {
            Goal goal = (Goal)session.getAttribute("goal");

            exercise.setGoal(goal);
            exerciseService.save(exercise);
        }

        return "addMinutes";
    }

    @RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
    public String getMinutes(@ModelAttribute("exercise") Exercise exercise) {

        return "addMinutes";
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public @ResponseBody List<Activity> findAllActivities() {

        return exerciseService.findAllActivities();
    }

}
