package sweet.poato.res.student;

import lombok.Data;

import java.io.Serializable;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/20 18:05
 */
@Data
public class StudentListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private int age;

    private int sex = 1;

    private int number = 1;

    private int classNumber = 1;

    private String state = "1";

    private String address = "广东深圳";

    private String phone = "19912341234";
}
