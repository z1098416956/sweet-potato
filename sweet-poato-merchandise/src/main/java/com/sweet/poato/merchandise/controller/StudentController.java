package com.sweet.poato.merchandise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.merchandise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
 * @date 2023/4/22 16:06
 */
@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/queryStudentPage", method = RequestMethod.POST)
    public Result<Page<StudentListVO>> queryStudentPage(@RequestBody StudentQueryVO studentQueryVO) {

        return studentService.queryStudentPage(studentQueryVO);
    }

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    public Result createStudent(@RequestBody CreateStudentVO createStudentVO) {

        return studentService.addStudent(createStudentVO);
    }

    @RequestMapping(value = "/queryStudentInfoPage", method = RequestMethod.POST)
    public Result<Page<StudentPageVO>> queryStudentInfoPage(@RequestBody StudentQueryVO studentQueryVO) {

        return studentService.queryStudentInfoPage(studentQueryVO);
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public Result updateStudent(@RequestBody UpdateStudentVO updateStudentVO) {

        return studentService.updateStudent(updateStudentVO);
    }

    @RequestMapping(value = "/deleteStudentInfo", method = RequestMethod.GET)
    public Result deleteStudentInfo(@RequestParam Long id){

        return studentService.deleteStudentInfo(id);
    }


    @RequestMapping(value = "/queryWorkPage", method = RequestMethod.POST)
    public Result<Page<WorkPageVO>> queryWorkPage(@RequestBody WorkQueryVO workQueryVO){

        return studentService.queryWorkPage(workQueryVO);
    }
}
