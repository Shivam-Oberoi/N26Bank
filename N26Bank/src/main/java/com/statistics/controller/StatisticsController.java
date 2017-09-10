package com.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statistics.model.ComputedStatistics;
import com.statistics.service.StatisticsService;

/**
 * Controller to present the computred Statistics.
 *
 * @author shivamoberoi
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public ComputedStatistics getStatistics(){
        return statisticsService.getStatistics();
    }
}
