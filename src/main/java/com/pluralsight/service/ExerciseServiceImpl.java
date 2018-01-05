package com.pluralsight.service;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Activity> findAllActivities() {

        List<Activity> activities = new ArrayList<>();

        Activity run = new Activity();
        run.setDesc("run");
        activities.add(run);

        Activity bike = new Activity();
        bike.setDesc("bike");
        activities.add(bike);

        Activity swim = new Activity();
        swim.setDesc("swim");
        activities.add(swim);

        return activities;
    }

    @Override
    @Transactional
    public Exercise save(Exercise exercise) {

        exercise = exerciseRepository.save(exercise);

        return exercise;
    }
}
