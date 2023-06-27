package sweet.poato.req.student;

import lombok.Data;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/9 15:36
 */
@Data
public class CreateStudentVO {

    private String name;

    private String phone;

    private Integer sex;

    private String address;

    private Integer age;

    private String father;

    private String mather;

    private String time;
}
