package com.sweet.poato.web.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import sweet.poato.req.student.CreateStudentVO;
import sweet.poato.req.student.StudentQueryVO;
import sweet.poato.req.student.UpdateStudentVO;
import sweet.poato.req.student.WorkQueryVO;
import sweet.poato.res.Test;
import sweet.poato.res.student.StudentListVO;
import sweet.poato.res.student.StudentPageVO;
import sweet.poato.res.student.WorkPageVO;
import sweet.poato.result.Result;

@FeignClient(name = "merchandise-service")
public interface MerchandiseApiService {


  @GetMapping("/test/getTestInfo")
  public Result<String> getTestInfo();

  @RequestMapping(value = "/test/getTestDTO",method = RequestMethod.GET)
  public Result<Test> getTestDTO();

  @RequestMapping(value = "/v1/student/queryStudentPage",method = RequestMethod.POST)
  public Result<Page<StudentListVO>> queryStudentPage(@RequestBody StudentQueryVO studentQueryVO);

  @RequestMapping(value = "/v1/student/createStudent",method = RequestMethod.POST)
  public Result createStudent(@RequestBody CreateStudentVO createStudentVO);

  @RequestMapping(value = "/v1/student/queryStudentInfoPage",method = RequestMethod.POST)
  public Result<Page<StudentPageVO>> queryStudentInfoPage(@RequestBody StudentQueryVO studentQueryVO);

  @RequestMapping(value = "/v1/student/updateStudent",method = RequestMethod.POST)
  public Result updateStudent(@RequestBody UpdateStudentVO updateStudentVO);

  @RequestMapping(value = "/v1/student/deleteStudentInfo",method = RequestMethod.GET)
  public Result deleteStudentInfo(@RequestParam Long id);

  @RequestMapping(value = "/v1/student/queryWorkPage",method = RequestMethod.POST)
  public Result<Page<WorkPageVO>> queryWorkPage(@RequestBody WorkQueryVO workQueryVO);
}
