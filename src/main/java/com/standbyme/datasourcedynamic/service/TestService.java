package com.standbyme.datasourcedynamic.service;

public interface TestService {
    String getCalcTaskById(Integer taskId);

    String getCalcTaskByIdJcf(Integer taskId);

    Integer insertCalcTask();
}
