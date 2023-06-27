package com.sweet.poato.web.controller.student;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.web.service.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
 * @date 2023/4/20 18:03
 */
@Slf4j
@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/queryStudentList",method = RequestMethod.GET)
    public Result<List<StudentListVO>> queryStudentList(){

        return studentService.queryStudentList();
    }

    @RequestMapping(value = "/web/queryStudentPage",method = RequestMethod.GET)
    public Result<Page<StudentListVO>> queryStudentPage(@RequestParam(required = false) String name){

        return studentService.queryStudentPage(name);
    }


    @RequestMapping(value = "/web/deleteStudent",method = RequestMethod.GET)
    public Result deleteStudent(@RequestParam Long id){
        log.info("id ===========> :{}",id);
        return Result.success(0,"删除成功");
    }


    @RequestMapping(value = "/web/addStudent",method = RequestMethod.POST)
    public Result addStudent(@RequestBody CreateStudentVO createStudentVO){
        log.info("CreateStudentVO ===========> :{}", JSON.toJSON(createStudentVO));
        return studentService.addStudent(createStudentVO);
    }

    @RequestMapping(value = "/web/queryStudentInfoPage",method = RequestMethod.GET)
    public Result<Page<StudentPageVO>> queryStudentInfoPage(){
        StudentQueryVO studentQueryVO = new StudentQueryVO();
        return studentService.queryStudentInfoPage(studentQueryVO);
    }

    @RequestMapping(value = "/web/updateStudent",method = RequestMethod.POST)
    public Result updateStudent(@RequestBody UpdateStudentVO updateStudentVO){
        log.info("UpdateStudentVO ===========> :{}", JSON.toJSON(updateStudentVO));
        return studentService.updateStudent(updateStudentVO);
    }

    @RequestMapping(value = "/web/deleteStudentInfo",method = RequestMethod.GET)
    public Result deleteStudentInfo(@RequestParam Long id){

        return studentService.deleteStudentInfo(id);
    }

    @RequestMapping(value = "/web/queryWorkPage",method = RequestMethod.POST)
    public Result<Page<WorkPageVO>> queryWorkPage(@RequestBody WorkQueryVO workQueryVO){

        return studentService.queryWorkPage(workQueryVO);
    }

    @RequestMapping(value = "/web/getViewList",method = RequestMethod.GET)
    public Result<DataViewV2VO> getViewList(){

        return studentService.getViewList();
    }
}
