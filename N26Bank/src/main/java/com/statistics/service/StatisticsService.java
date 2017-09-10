package com.statistics.service;

import com.statistics.model.ComputedStatistics;
import com.statistics.model.Transaction;

/**
 * @author shivamoberoi
 */
public interface StatisticsService {

    void computeStatistics(Transaction transaction);

    ComputedStatistics getStatistics();

}
