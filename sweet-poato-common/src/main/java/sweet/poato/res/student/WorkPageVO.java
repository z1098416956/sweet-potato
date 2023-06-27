package sweet.poato.res.student;

import lombok.Data;

import java.io.Serializable;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/10 13:33
 */
@Data
public class WorkPageVO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long classId;

    private String title;

    private Integer completed;
}
