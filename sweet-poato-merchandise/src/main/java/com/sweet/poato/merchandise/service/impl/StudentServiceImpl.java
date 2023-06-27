package com.sweet.poato.merchandise.service.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.merchandise.dao.StudentDao;
import com.sweet.poato.merchandise.dao.StudentInfoDao;
import com.sweet.poato.merchandise.entity.StudentInfoEntity;
import com.sweet.poato.merchandise.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
 * @date 2023/4/22 16:01
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Override
    public Result<Page<StudentListVO>> queryStudentPage(StudentQueryVO studentQueryVO) {
        IPage<StudentListVO> page = new Page<>();
        page.setSize(studentQueryVO.getSize());
        page.setCurrent(studentQueryVO.getPage());
        Page<StudentListVO> iPage = studentDao.queryStudentPage(studentQueryVO.getPage(),
                studentQueryVO.getSize(),studentQueryVO.getName(), page);
     //   long total = iPage.getTotal();
     //   log.info("total =====> :{}",total);
        return Result.success("成功",iPage);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result addStudent(CreateStudentVO createStudentVO) {
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
        BeanUtils.copyProperties(createStudentVO,studentInfoEntity);
        int insert = studentInfoDao.insert(studentInfoEntity);
        if (insert == 0){
            return Result.error(500,"添加失败");
        }
        return Result.success(0,"添加成功");
    }

    @Override
    public Result<Page<StudentPageVO>> queryStudentInfoPage(StudentQueryVO studentQueryVO) {
        IPage<StudentPageVO> page = new Page<>();
        page.setSize(studentQueryVO.getSize());
        page.setCurrent(studentQueryVO.getPage());
        Page<StudentPageVO> iPage = studentInfoDao.queryStudentInfoPage(page);
        return Result.success("成功",iPage);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result updateStudent(UpdateStudentVO updateStudentVO) {
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
        BeanUtils.copyProperties(updateStudentVO,studentInfoEntity);
        int i = studentInfoDao.updateById(studentInfoEntity);
        if (i == 0){
            return Result.error(500,"更新失败");
        }
        return Result.success(0,"更新成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result deleteStudentInfo(Long id) {
        int i = studentInfoDao.deleteById(id);
        if (i == 0){
            return Result.error(500,"删除失败");
        }
        return Result.success(0,"删除成功");
    }

    @Override
    public Result<Page<WorkPageVO>> queryWorkPage(WorkQueryVO workQueryVO) {
        IPage<WorkPageVO> page = new Page<>();
        page.setSize(workQueryVO.getSize());
        page.setCurrent(workQueryVO.getPage());
        Page<WorkPageVO> workPageVOPage = studentDao.queryWorkPage(page);
        return Result.success("成功",workPageVOPage);
    }
}
