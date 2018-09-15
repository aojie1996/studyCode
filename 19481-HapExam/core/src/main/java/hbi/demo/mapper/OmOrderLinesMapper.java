package hbi.demo.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.demo.dto.OmOrderLines;

import java.util.List;

public interface OmOrderLinesMapper extends Mapper<OmOrderLines>{
    /**
     * 自己定义的查询方法,通过headerId查询
     * @param omOrderLines
     * @return
     */
    List<OmOrderLines> findByHeaderId(OmOrderLines omOrderLines);

}