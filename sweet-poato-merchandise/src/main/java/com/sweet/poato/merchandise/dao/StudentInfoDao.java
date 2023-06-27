package com.sweet.poato.merchandise.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sweet.poato.merchandise.entity.StudentInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import sweet.poato.base.CommonMapper;
import sweet.poato.res.student.StudentPageVO;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/9 16:23
 */
@Mapper
public interface StudentInfoDao extends CommonMapper<StudentInfoEntity> {

    public Page<StudentPageVO> queryStudentInfoPage(IPage<StudentPageVO> iPage);
}
