package com.zy.code.controller;

import com.zy.code.utils.ProcessResult;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeacherViewControllor extends BaseControllor {

    /**
     * 根据年份和期中期末查询成绩
     *
     * @param studentId
     * @param year
     * @param midOrEnd
     * @return
     */
    @RequestMapping(value = "/getStudentCompareClass", method = RequestMethod.GET)
    public ProcessResult index(@Param("studentId") Long studentId,
                                  @Param("year") Integer year,
                                  @Param("midOrEnd") Integer midOrEnd) {
        ProcessResult processResult = teacherService.getStudentScoreCompareClassAvg(studentId, year, midOrEnd);
        return processResult;
    }


}
