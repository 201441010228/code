package com.zy.code.serviceBiz;

import com.zy.code.entity.*;
import com.zy.code.utils.ProcessResult;

public interface AdminService {

    ProcessResult getClassListBySchoolId(Long schoolId);

    ProcessResult getSchoolList();

    ProcessResult getTeacherListBySchoolId(Long schoolId);

    ProcessResult saveStudent(Student student);

    ProcessResult deleteStudent(Long studentId);

    ProcessResult saveSubject(Subject subject);

    ProcessResult deleteSubject(Long subjectId);

    ProcessResult saveTeacher(Teacher teacher);

    ProcessResult deleteTeacher(Long teacherId);

    ProcessResult saveScore(Score score);

    ProcessResult deleteScore(Long scoreId);

    ProcessResult saveTeacherAndSubject(TeacherAndSubject teacherAndSubject);

    ProcessResult deleteTeacherAndSubject(Long teacherAndSubjectId);

    ProcessResult saveSchool(School school);

    ProcessResult deleteSchool(Long schoolId);

    ProcessResult saveClassInSchool(ClassInSchool classInSchool);

    ProcessResult deleteClassInSchool(Long classInSchoolId);

    ProcessResult login(Teacher teacher);
}
