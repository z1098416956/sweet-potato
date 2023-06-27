package com.sweet.poato.merchandise.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.merchandise.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sweet.poato.base.CommonMapper;
import sweet.poato.res.student.StudentListVO;
import sweet.poato.res.student.WorkPageVO;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/22 15:44
 */
@Mapper
public interface StudentDao extends CommonMapper<StudentEntity> {

    public Page<StudentListVO> queryStudentPage(@Param("page") Integer page,
                                                @Param("size") Integer size,
                                                @Param("name") String name,
                                                IPage<StudentListVO> iPage);



    public Page<WorkPageVO> queryWorkPage(IPage<WorkPageVO> iPage);
}
