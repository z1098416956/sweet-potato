package com.sweet.poato.web.service.student.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.web.feign.MerchandiseApiService;
import com.sweet.poato.web.service.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweet.poato.req.student.CreateStudentVO;
import sweet.poato.req.student.StudentQueryVO;
import sweet.poato.req.student.UpdateStudentVO;
import sweet.poato.req.student.WorkQueryVO;
import sweet.poato.res.student.*;
import sweet.poato.result.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/20 18:07
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private MerchandiseApiService merchandiseApiService;

    @Override
    public Result<List<StudentListVO>> queryStudentList() {
        StudentListVO studentListRes = new StudentListVO();
        studentListRes.setAge(18);
        studentListRes.setId(1L);
        studentListRes.setName("小明");
        List<StudentListVO> res = new ArrayList<>();
        res.add(studentListRes);
        StudentListVO listRes = new StudentListVO();
        listRes.setAge(22);
        listRes.setId(2L);
        listRes.setName("小虎");
        res.add(listRes);
        return Result.success("成功",res);
    }

    @Override
    public Result<Page<StudentListVO>> queryStudentPage(String name) {
        StudentQueryVO studentQueryVO = new StudentQueryVO();
        studentQueryVO.setSize(500);
        studentQueryVO.setName(name);
        Result<Page<StudentListVO>> result = merchandiseApiService.queryStudentPage(studentQueryVO);
        result.getData().setTotal(result.getData().getTotal() == 500?result.getData().getTotal():500);
        return result ;
    }

    @Override
    public Result addStudent(CreateStudentVO createStudentVO) {

        return merchandiseApiService.createStudent(createStudentVO);
    }

    @Override
    public Result<Page<StudentPageVO>> queryStudentInfoPage(StudentQueryVO studentQueryVO) {

        return merchandiseApiService.queryStudentInfoPage(studentQueryVO);
    }

    @Override
    public Result updateStudent(UpdateStudentVO updateStudentVO) {
        return merchandiseApiService.updateStudent(updateStudentVO);
    }

    @Override
    public Result deleteStudentInfo(Long id) {
        return merchandiseApiService.deleteStudentInfo(id);
    }

    @Override
    public Result<Page<WorkPageVO>> queryWorkPage(WorkQueryVO workQueryVO) {


        return merchandiseApiService.queryWorkPage(workQueryVO);
    }

    @Override
    public Result<DataViewV2VO> getViewList() {
        DataViewV2VO dataViewV2VO = new DataViewV2VO();
        String legend[] ={"技术总监","产品经理","后端开发","前端开发","运维/测试",};
        String xAxis[] = {"周一","周二","周三","周四","周五","周六","周日"};
        dataViewV2VO.setLegend(legend);
        dataViewV2VO.setXAxis(xAxis);
        List<DataViewVO> list = new ArrayList<>();
        int arr[] = {333,223,424,525,213,545,443};
        int arr1[] = {111,222,333,444,535,646,717};
        int arr2[] = {332,122,432,555,237,585,123};
        int arr3[] = {331,223,445,557,238,515,133};
        int arr4[] = {373,262,443,559,283,585,212};
        DataViewVO.builder().data(arr)
                .type("line")
                .stack("总量")
                .type("line")
                .name("技术总监")
                .build();
        list.add(DataViewVO.builder().data(arr)
                .type("line")
                .stack("总量")
                .type("line")
                .name("产品经理")
                .build());
        list.add(DataViewVO.builder().data(arr1)
                .type("line")
                .stack("总量")
                .type("line")
                .name("后端开发")
                .build());
        list.add(DataViewVO.builder().data(arr2)
                .type("line")
                .stack("总量")
                .type("line")
                .name("前端开发")
                .build());
        list.add(DataViewVO.builder().data(arr3)
                .type("line")
                .stack("总量")
                .type("line")
                .name("运维/测试")
                .build());
        /*list.add(DataViewVO.builder().data(arr4)
                .type("line")
                .stack("总量")
                .type("line")
                .name("前端aa")
                .build());*/
        dataViewV2VO.setSeries(list);
        return Result.success("成功",dataViewV2VO);
    }
}
