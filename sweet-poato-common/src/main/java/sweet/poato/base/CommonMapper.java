package sweet.poato.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:26
 * @Version 1.0
 */
public interface CommonMapper <T> extends BaseMapper<T> {

    /**
     * 批量插入
     *
     * @param collection 批量插入数据
     * @return ignore
     */
    int insertByBatch(@Param("collection") Collection<T> collection);

    /**
     * 批量更新
     *
     * @param collection 批量更新数据
     * @return ignore
     */
    int updateByBatch(@Param("collection") Collection<T> collection);
}
