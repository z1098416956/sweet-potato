package sweet.poato.base;


import lombok.Data;

import java.util.Date;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:16
 * @Version 1.0
 */
@Data
public class BaseEntity {

    /**
     * 创建者
     */
    private String createBy;
    /**
     *
     * 更新者
     */
    private String updateBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除 0 未删除 1已删除
     */
    private Integer isDel;
}
