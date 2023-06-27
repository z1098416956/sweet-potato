package com.sweet.poato.merchandise.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import sweet.poato.req.student.CreateStudentVO;
import sweet.poato.req.student.StudentQueryVO;
import sweet.poato.req.student.UpdateStudentVO;
import sweet.poato.req.student.WorkQueryVO;
import sweet.poato.res.student.StudentListVO;
import sweet.poato.res.student.StudentPageVO;
import sweet.poato.res.student.WorkPageVO;
import sweet.poato.result.Result;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/22 15:59
 */
public interface StudentService {

    public Result<Page<StudentListVO>> queryStudentPage(StudentQueryVO studentQueryVO);

    public Result addStudent(CreateStudentVO createStudentVO);

    public Result<Page<StudentPageVO>> queryStudentInfoPage(StudentQueryVO studentQueryVO);

    public Result updateStudent(UpdateStudentVO updateStudentVO);

    public Result deleteStudentInfo(Long id);

    public Result<Page<WorkPageVO>> queryWorkPage(WorkQueryVO workQueryVO);
}
