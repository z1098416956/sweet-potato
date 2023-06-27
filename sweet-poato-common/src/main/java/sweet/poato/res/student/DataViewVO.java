package sweet.poato.res.student;

import lombok.Builder;
import lombok.Data;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/11 14:02
 */
@Data
@Builder
public class DataViewVO {

    private String name;

    private String type;

    private String stack;

    private int data[];
}
