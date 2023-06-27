package sweet.poato.req.student;

import lombok.Data;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/4/22 16:00
 */
@Data
public class StudentQueryVO {

    private Integer page = 1;

    private Integer size = 10;

    private String name;
}
