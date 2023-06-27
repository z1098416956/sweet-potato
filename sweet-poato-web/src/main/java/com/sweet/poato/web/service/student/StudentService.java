package com.sweet.poato.web.service.student;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import sweet.poato.req.student.CreateStudentVO;
import sweet.poato.req.student.StudentQueryVO;
import sweet.poato.req.student.UpdateStudentVO;
import sweet.poato.req.student.WorkQueryVO;
import sweet.poato.res.student.*;
import sweet.poato.result.Result;

import java.util.List;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/20 18:06
 */
public interface StudentService {

    public Result<List<StudentListVO>> queryStudentList();

    public Result<Page<StudentListVO>> queryStudentPage(String name);

    public Result addStudent(CreateStudentVO createStudentVO);

    public Result<Page<StudentPageVO>> queryStudentInfoPage(StudentQueryVO studentQueryVO);

    public Result updateStudent(UpdateStudentVO updateStudentVO);

    public Result deleteStudentInfo(Long id);

    public Result<Page<WorkPageVO>> queryWorkPage(WorkQueryVO workQueryVO);

    public Result<DataViewV2VO> getViewList();
}
