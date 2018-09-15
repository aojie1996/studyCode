package hbi.demo.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.demo.dto.OmOrderLines;

import java.util.List;

public interface IOmOrderLinesService extends IBaseService<OmOrderLines>, ProxySelf<IOmOrderLinesService>{
    /**
     * 自定义的一个保存行信息的方法
     * @param request
     * @param list
     * @return
     */
    List<OmOrderLines> myBatchSubmit(IRequest request, List<OmOrderLines> list);

    /**
     * 通过headerId查出行
     * @param omOrderLines
     * @return
     */
    List<OmOrderLines> findByHeaderId(OmOrderLines omOrderLines);

}