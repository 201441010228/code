package com.zy.code.serviceBiz.Impl;

import com.zy.code.entity.Score;
import com.zy.code.entity.Student;
import com.zy.code.entity.Subject;
import com.zy.code.serviceBiz.TeacherService;
import com.zy.code.utils.CodeMessageConstants;
import com.zy.code.utils.ProcessResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class TeacherServiceImpl extends BaseServiceImpl implements TeacherService {


    /**
     * 某学年学生成绩 期中或期末
     *
     * @param studentId
     * @param year
     * @param midOrEnd
     * @return
     */
    @Override
    public ProcessResult getStudentScoreCompareClassAvg(Long studentId, Integer year, Integer midOrEnd) {
        ProcessResult processResult = new ProcessResult();
        if (studentId == null || year == null || midOrEnd == null) {
            processResult.setStatus(CodeMessageConstants.PARAMNULL_ERROR.getStatus());
            processResult.setMessage(CodeMessageConstants.PARAMNULL_ERROR.getMessage());
            return processResult;
        }
        Student student = studentRepository.getOne(studentId);
        Long classInSchoolId = student.getClassInSchoolId();
        Long schoolId = student.getSchoolId();
        List<Subject> subjectList = subjectRespository.findBySchoolId(schoolId);
        if (null == subjectList || subjectList.size() <= 0) {
            processResult.setStatus(CodeMessageConstants.SERVER_ERROR.getStatus());
            processResult.setMessage("请先填写学校科目");
            return processResult;
        }
        processResult.getData().put("subjects", subjectList);
        List<Student> studentList = studentRepository.findStudentByClassInSchoolIdAndYear(classInSchoolId, year);
        //计算各学科总成绩
        if (null != studentList && studentList.size() > 0) {
            for (Student stu : studentList) {
                Long stuId = stu.getId();
                List<Score> scoreList = scoreRespository.findScoreByStudentIdAndYear(stuId, year, midOrEnd);
                for (Subject sub : subjectList) {
                    for (Score sco : scoreList) {
                        if (sub.getId().equals(sco.getSubjectId())) {
                            String subName = sub.getSubjectName() + "Sum";
                            if (null == processResult.getData().get(subName)) {
                                processResult.getData().put(subName, 0);
                            } else {
                                Double sum = Double.parseDouble(processResult.getData().get(subName).toString());
                                sum = sum + sco.getScoreNumber();
                                processResult.getData().put(subName, sum);
                            }
                            //找出所查学生的成绩
                            if (sco.getStudentId().equals(studentId)) {
                                processResult.getData().put("studentScore", sco.getScoreNumber());
                            }
                        }
                    }
                }
            }
        }
        //放入各学科平均成绩
        for (Subject sub : subjectList) {
            String subName = sub.getSubjectName() + "Sum";
            Double sum = Double.parseDouble(processResult.getData().get(subName).toString());
            processResult.getData().put("Avg", sum / studentList.size());
        }
        return processResult;
    }

    /**
     * 根据科目id获取学生以往的所有成绩
     *
     * @param studentId
     * @param subjectId
     * @return
     */
    @Override
    public ProcessResult getStudentSubjectScoreHistory(Long studentId, Long subjectId) {
        ProcessResult processResult = new ProcessResult();
        if (studentId == null || subjectId == null) {
            processResult.setStatus(CodeMessageConstants.PARAMNULL_ERROR.getStatus());
            processResult.setMessage(CodeMessageConstants.PARAMNULL_ERROR.getMessage());
            return processResult;
        }
        Subject subject = subjectRespository.getOne(subjectId);
        List<Score> scoreList = scoreRespository.findScoreByStudentIdAndSubjectId(studentId, subjectId);
        if (scoreList != null) {
            scoreList.sort(new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    return o1.getYear() - o2.getYear();
                }
            });
        }
        List<Integer> year = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        for (Score score : scoreList) {
            if (!year.contains(score.getYear() + score.getMidOrEnd())) {
                year.add(score.getYear() + score.getMidOrEnd());
                scores.add(score.getScoreNumber());
            }
        }
        processResult.setStatus(CodeMessageConstants.SUCCESS.getStatus());
        processResult.setMessage(CodeMessageConstants.SUCCESS.getMessage());
        processResult.getData().put("years", year);
        processResult.getData().put("scores", scores);
        processResult.getData().put("subjectName", subject.getSubjectName());
        return processResult;
    }

    /**
     * 获取学生总成绩
     * @param classInSchoolId
     * @param year
     * @param midOrEnd
     * @return
     */
    @Override
    public ProcessResult getOrders(Long classInSchoolId, Integer year, Integer midOrEnd) {
        ProcessResult processResult = new ProcessResult();
        if (classInSchoolId == null || year == null || midOrEnd == null) {
            processResult.setStatus(CodeMessageConstants.PARAMNULL_ERROR.getStatus());
            processResult.setMessage(CodeMessageConstants.PARAMNULL_ERROR.getMessage());
            return processResult;
        }
        List<Student> studentList = studentRepository.findStudentByClassInSchoolIdAndYear(classInSchoolId, year);
        List<Map<String, Double>> totalNum = new ArrayList<>();
        for (Student student : studentList) {
            Map<String, Double> map = new HashMap<>();
            List<Score> scoreList = scoreRespository.findScoreByStudentIdAndYear(student.getId(), year, midOrEnd);
            Double sum = 0D;
            for (Score score : scoreList) {
                sum += score.getScoreNumber();
            }
            map.put(student.getStudentName(), sum);
            totalNum.add(map);
        }
        processResult.setStatus(CodeMessageConstants.SUCCESS.getStatus());
        processResult.setMessage(CodeMessageConstants.SUCCESS.getMessage());
        processResult.getData().put("totalNumList", totalNum);
        return processResult;
    }


}
