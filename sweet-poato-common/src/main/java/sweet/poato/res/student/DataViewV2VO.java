package sweet.poato.res.student;

import lombok.Data;

import java.util.List;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/11 14:16
 */
@Data
public class DataViewV2VO {

    private String legend[];

    private String xAxis[];

    private List<DataViewVO> series;
}
