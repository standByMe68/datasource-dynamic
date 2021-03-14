package com.standbyme.datasourcedynamic.mapper;

import com.standbyme.datasourcedynamic.domain.CalcTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Mapper
public interface TestMapper {

    CalcTask getTaskById(@Param("taskId") Integer taskId);

    Integer insertCalcTask(CalcTask calcTask);
}
