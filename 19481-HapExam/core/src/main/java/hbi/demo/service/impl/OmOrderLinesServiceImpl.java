package hbi.demo.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.demo.mapper.OmOrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hbi.demo.dto.OmOrderLines;
import hbi.demo.service.IOmOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderLinesServiceImpl extends BaseServiceImpl<OmOrderLines> implements IOmOrderLinesService{


    @Autowired
    private OmOrderLinesMapper omOrderLinesMapper;

    @Autowired
    private IOmOrderLinesService orderLinesService;

    @Override
    public List<OmOrderLines> myBatchSubmit(IRequest request, List<OmOrderLines> list) {
        if(list != null && !list.isEmpty()){
            for(int i = 0 ; i<list.size();i++){
                OmOrderLines omOrderLines = list.get(i);
                Long lineId = omOrderLines.getLineId();
                if(lineId == null || lineId == 0){

                    orderLinesService.insertSelective(request,omOrderLines);
                }else{

                    orderLinesService.updateByPrimaryKeySelective(request,omOrderLines);
                }
            }
        }
        return list;

    }

    @Override
    public List<OmOrderLines> findByHeaderId(OmOrderLines omOrderLines) {
        return omOrderLinesMapper.findByHeaderId(omOrderLines);
    }


}