package com.sweet.poato.merchandise.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/9 16:21
 */
@Data
@TableName("test_student_info")
public class StudentInfoEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;

    private String phone;

    private Integer sex;

    private String address;

    private Integer age;

    private String father;

    private String mather;

    private String time;
}
