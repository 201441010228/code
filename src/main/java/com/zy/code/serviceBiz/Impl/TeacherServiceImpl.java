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
        List<Student> studentList = studentRepository.findStudentByClassInSchoolId(classInSchoolId);
        //计算各学科总成绩
        if (null != studentList && studentList.size() > 0) {
            List<Double> studentScoreList = new ArrayList<>();
            for (Student stu : studentList) {
                Long stuId = stu.getId();
                List<Score> scoreList = scoreRespository.findScoreByStudentIdAndYear(stuId, year, midOrEnd);
                for (Subject sub : subjectList) {
                    for (Score sco : scoreList) {
                        if (sub.getId().equals(sco.getSubjectId())) {
                            String subName = sub.getSubjectNameEnglish();
                            if (null == processResult.getData().get(subName)) {
                                processResult.getData().put(subName, sco.getScoreNumber());
                            } else {
                                Double sum = Double.parseDouble(processResult.getData().get(subName).toString());
                                sum = sum + sco.getScoreNumber();
                                processResult.getData().put(subName, sum);
                            }
                            //找出所查学生的成绩
                            if (sco.getStudentId().equals(studentId)) {
                                studentScoreList.add(sco.getScoreNumber());
                            }
                        }
                    }
                }
            }
            processResult.getData().put("student",studentScoreList);
        }
        //放入各学科平均成绩
        List<Double> avg = new ArrayList<>();
        List<String> subjectNames = new ArrayList<>();
        List<String> compareData =  new ArrayList<>();
        compareData.add("学生成绩");
        compareData.add("班级平均成绩");
        for (Subject sub : subjectList) {
            String subName = sub.getSubjectNameEnglish();
            Double sum = Double.parseDouble(processResult.getData().get(subName).toString());
            processResult.getData().remove(subName);
            avg.add(sum / studentList.size());
            subjectNames.add(sub.getSubjectNameEnglish());
        }
        processResult.getData().put("Avg", avg);
        processResult.getData().put("subjectNames",subjectNames);
        processResult.getData().put("compareData",compareData);
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
        List<Student> studentList = studentRepository.findStudentByClassInSchoolId(classInSchoolId);
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

    @Override
    public ProcessResult getHistoryViewByStudentId(Long studentId,Long schoolId) {
        ProcessResult processResult = new ProcessResult();
        List<String> subjects = new ArrayList<>();
        List<Map<String,Object>> services = new ArrayList<>();
        if (studentId == null || schoolId == null ) {
            processResult.setStatus(CodeMessageConstants.PARAMNULL_ERROR.getStatus());
            processResult.setMessage(CodeMessageConstants.PARAMNULL_ERROR.getMessage());
            return processResult;
        }
        List<Subject> subjectList = subjectRespository.findBySchoolId(schoolId);
        if (null == subjectList || subjectList.size() <= 0) {
            processResult.setStatus(CodeMessageConstants.SERVER_ERROR.getStatus());
            processResult.setMessage("请先填写学校科目");
            return processResult;
        }
        List<Score> scoreList = scoreRespository.findScoreByStudentId(studentId);
        scoreList.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                 int returnValue = o1.getYear()-o2.getYear();
                if (returnValue != 0){
                    return  returnValue;
                }else {
                     return o1.getMidOrEnd()-o2.getMidOrEnd();
                }
            }
        });
        for (Subject subject: subjectList) {
            List<Double> scores = new ArrayList<>();
            Map<String,Object> map = new HashMap<>();
            map.put("name",subject.getSubjectNameEnglish());
            map.put("type","line");
            for (Score sco:scoreList) {
                if (sco.getSubjectId().equals(subject.getId())){
                    scores.add(sco.getScoreNumber());
                }
            }
            map.put("data",scores);
            services.add(map);
            subjects.add(subject.getSubjectNameEnglish());
        }
        processResult.getData().put("series",services);
        Set<String> dateList = new LinkedHashSet<>();
        for (Score sco:scoreList) {
            dateList.add(sco.getYear().toString()+(sco.getMidOrEnd()==0?" Midsemester":" Final exam"));
        }
        processResult.getData().put("dateList",dateList);
        processResult.getData().put("subjectNames",subjects);
        return processResult;
    }

    @Override
    public ProcessResult predictStudentScore(Long studentId,Long schoolId) {
        ProcessResult processResult = new ProcessResult();
        StringBuffer predictMessage = new StringBuffer();
        //状态为1 为良好  0 不好
        Map<String,Integer> subjectStatus = new HashMap<>();
        predictMessage.append("<center><strong>成绩报告</strong></center><br>");
        predictMessage.append("您的成绩预测报告如下：<br>");
        if (studentId == null) {
            processResult.setStatus(CodeMessageConstants.PARAMNULL_ERROR.getStatus());
            processResult.setMessage(CodeMessageConstants.PARAMNULL_ERROR.getMessage());
            return processResult;
        }
        List<Subject> subjectList = subjectRespository.findBySchoolId(schoolId);
        if (null == subjectList || subjectList.size() <= 0) {
            processResult.setStatus(CodeMessageConstants.SERVER_ERROR.getStatus());
            processResult.setMessage("请先填写学校科目");
            return processResult;
        }
        List<Score> scoreList = scoreRespository.findScoreByStudentId(studentId);
        if (scoreList.size()<=3){
            processResult.setStatus(CodeMessageConstants.SCORE_SIZE_LESS.getStatus());
            processResult.setMessage(CodeMessageConstants.SCORE_SIZE_LESS.getMessage());
            return processResult;
        }
        scoreList.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                int returnValue = o1.getYear()-o2.getYear();
                if (returnValue != 0){
                    return  returnValue;
                }else {
                    return o1.getMidOrEnd()-o2.getMidOrEnd();
                }
            }
        });
        Map<String,Double> lastScoreMap = new HashMap<>();
        for (Subject sub: subjectList) {
            Double goodPercent = 0D;
            for (Score sco:scoreList) {
                if (!sub.getId().equals(sco.getSubjectId())){
                    continue;
                }
                if (lastScoreMap.get(sub.getSubjectNameEnglish())== null){
                    lastScoreMap.put(sub.getSubjectNameEnglish(),sco.getScoreNumber());
                }else{
                    Double lastScore = lastScoreMap.get(sub.getSubjectNameEnglish());
                    lastScoreMap.put(sub.getSubjectNameEnglish(),lastScore + sco.getScoreNumber());
                }
                goodPercent += sco.getScoreNumber()/sub.getFullMarks();
            }
            Double line = goodPercent/subjectList.size();
            if (line<=0.6){
                predictMessage.append("您的"+sub.getSubjectName()+"成绩历史趋势不是很完美,有待于提高，加油！并注意调整学习方法。<br>");
                subjectStatus.put(sub.getSubjectNameEnglish(),0);
            }else if(line>0.6 && line<0.8){
                predictMessage.append("您的"+sub.getSubjectName()+"成绩历史趋势为良好，请继续保持,加油！祝您成绩更上一层楼。<br>");
                subjectStatus.put(sub.getSubjectNameEnglish(),1);
            }else {
                predictMessage.append("您的"+sub.getSubjectName()+"成绩历史趋势为优秀，请继续保持,加油！注意身体，培养其他兴趣爱好。<br>");
                subjectStatus.put(sub.getSubjectNameEnglish(),1);
            }
        }
        for (Map.Entry<String,Double> entry:lastScoreMap.entrySet()) {
             String key = entry.getKey();
             Double value = entry.getValue();
             processResult.getData().put(key+"Avg",value/(scoreList.size()/subjectList.size()));
        }
        for (Subject s :subjectList) {
            Double sum = 0D;
            for (Score score:scoreList) {
                if (s.getId().equals(score.getSubjectId())){
                   Double subjectAvg = Double.parseDouble(processResult.getData().get(s.getSubjectNameEnglish()+"Avg").toString());
                   sum =  (score.getScoreNumber()-subjectAvg)*(score.getScoreNumber()-subjectAvg);
                }
            }
            Double d = Math.sqrt(sum/(scoreList.size()/subjectList.size()));
            processResult.getData().put(s.getSubjectNameEnglish()+"variance",d);
             Integer statu = subjectStatus.get(s.getSubjectNameEnglish());
            if (d/s.getFullMarks()>0.2){
                predictMessage.append("从"+s.getSubjectName()+"成绩的标准差来看,该科目成绩波动不大。<br>");
                if (statu==0){
                    predictMessage.append("综合以上信息,系统认为您下一次"+s.getSubjectName()+"科成绩,不太乐观，请努力！！<br>");
                }else{
                    predictMessage.append("综合以上信息,系统认为您下一次"+s.getSubjectName()+"科成绩,会很理想。<br>");
                }
            }else {
                predictMessage.append("从" + s.getSubjectName() + "成绩的标准差来看,该科目成绩波动比较大。请注意<br>");
                if (statu==0){
                    predictMessage.append("综合以上信息,系统认为您下一次"+s.getSubjectName()+"科成绩,不太乐观，但请认真复习。认真作答试卷<br>");
                }else{
                    predictMessage.append("综合以上信息,系统认为您下一次"+s.getSubjectName()+"科成绩,比较理想，但请认真复习。认真作答试卷<br>");
                }
            }

        }
        processResult.setStatus(CodeMessageConstants.SUCCESS.getStatus());
        processResult.getData().put("predictMessage",predictMessage.toString());
        return processResult;
    }


}
