package sweet.poato.res.student;

import lombok.Data;

import java.io.Serializable;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/9 15:36
 */
@Data
public class StudentPageVO  implements Serializable {

    private static final long serialVersionUID = 1L;

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
