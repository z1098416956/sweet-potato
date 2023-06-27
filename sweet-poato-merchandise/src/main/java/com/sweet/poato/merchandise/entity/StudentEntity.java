package com.sweet.poato.merchandise.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import sweet.poato.base.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/22 15:38
 */
@Data
public class StudentEntity extends BaseEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @Length(max=20,message = "姓名长度不能超过20个字符")
    @NotBlank(message="姓名不能为空")
    private String name;//学生姓名
    @NotBlank(message = "学生用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_-]{5,19}$", message = "用户名格式不正确，请重新输入，用户名必须包含【6-20位字母、数字、下划线和减号】")
    private String userName;//用户名
    @NotNull(message = "班级不能为空")
    private Long classesId;//班级ID
    @TableField(exist = false)
    private String classesName;//班级名称
    private String phone;//学生手机号
    @NotBlank(message = "主监护人手机号不能为空")
    @Pattern(regexp = "^1([3-9])[0-9]{9}$", message="主监护人手机号格式不正确，请重新输入")
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String primaryGuardianPhone;//主监护人手机号
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String deputyGuardianPhone;//副监护人手机号

    @TableField(exist = false)
    private Long guardianId;

    private String studentNo;//学号
    private String icCardNo;//IC卡号
    private Integer sex;//性别（1:男、0:女）
    private String hometown;//籍贯
    private String accountTypes;//户口类型（0:未落常住户口、1:非农业家庭户口、2:农业家庭户口、3:非农业集体户口、4:农业集体户口、5:自理口粮户口、6:寄住户口、7:暂住户口、8:其他户口）
    private String birthPlace;//出生地
    private String national;//民族
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;//出生日期
    private String bloodType;//血型(0:A血型、1:B血型、2:AB血型、3:O血型、4:RH 阳性血型、5:RH 阴性血型、6:HLA 血型)
    private String politicalStatus;//政治面貌[0:中国共产党党员、1:中国共产党预备党员、2:中国共产主义青年团团员、3:中国国民党革命委员会会员、4:中国民主同盟盟员、5:中国民主建国会会员、6:中国民主促进会会员、7:中国农工民主党党员、8:中国致公党党员、9:九三学社社员、10:台湾民主自治同盟盟员、11:无党派民主人士、12:群众]
    private String cardType;//证件类型（0:身份证、1:军官证、2:护照、3:港澳居民身份证、4:台湾居民来往大陆通行证）
    private String cardNumber;//证件号码
    private Date enrollmentDate;//入学日期
    private String onlyChild;//是否独生子女（0:是、1:否）
    private String healthStatus;//健康状况（0:健康或良好、1:一般或较弱、2:有慢性病、3:残疾）
    private String personalIllness;//个人疾病情况
    private String accommodation;//住宿方式（0:走读、1:住校、2:借宿、3:其他）
    private String address;//家庭住址
    private String faceInformation;//人脸信息
    private String specialty;//特长
    private Long schoolId;//学校ID
    private String remarks;//备注
    private Long userId;//用户ID
    /**
     * 版本戳
     */
    private Integer versionStamp;

}
