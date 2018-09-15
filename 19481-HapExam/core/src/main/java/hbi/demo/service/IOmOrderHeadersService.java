package hbi.demo.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.demo.dto.OmOrderHeaders;
import hbi.demo.dto.OmOrderLines;

import java.util.List;

public interface IOmOrderHeadersService extends IBaseService<OmOrderHeaders>, ProxySelf<IOmOrderHeadersService>{
    List<OmOrderHeaders> selectCustAndCompany(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize);
    /**
     * 自定义保存头行方法
     * @param request
     * @param list
     * @return
     */
    List<OmOrderHeaders> batchSubmit(IRequest request,List<OmOrderHeaders> list);


    /**
     * 自定义删除方法，删除头行
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    int myBatchDelete(IRequest request,List<OmOrderHeaders> dto) throws Exception;
}