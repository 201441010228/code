package com.zy.code.serviceBiz;

import com.zy.code.utils.ProcessResult;

public interface TeacherService {


    ProcessResult getStudentScoreCompareClassAvg(Long studentId, Integer year,Integer midOrEnd);


    ProcessResult getStudentSubjectScoreHistory(Long studentId,Long subjectId);

    ProcessResult getOrders(Long classInSchoolId,Integer year,Integer midOrEnd);

}
