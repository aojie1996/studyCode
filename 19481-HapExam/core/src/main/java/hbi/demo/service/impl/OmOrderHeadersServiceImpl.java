package hbi.demo.service.impl;

import com.hand.hap.code.rule.exception.CodeRuleException;
import com.hand.hap.code.rule.service.ISysCodeRuleProcessService;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.demo.dto.OmOrderLines;
import hbi.demo.mapper.OmOrderHeadersMapper;
import hbi.demo.service.IOmOrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hbi.demo.dto.OmOrderHeaders;
import hbi.demo.service.IOmOrderHeadersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderHeadersServiceImpl extends BaseServiceImpl<OmOrderHeaders> implements IOmOrderHeadersService {

    @Autowired
    OmOrderHeadersMapper omOrderHeadersMapper;

    @Autowired
    ISysCodeRuleProcessService sysCodeRuleProcessService;

    @Autowired
    IOmOrderHeadersService omOrderHeadersService;

    @Autowired
    private IOmOrderLinesService orderLinesService;

    @Override
    public List<OmOrderHeaders> selectCustAndCompany(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize) {
//        List<OmOrderHeaders> omOrderHeaders = omOrderHeadersMapper.selectCustAndCompany(dto);
//        return omOrderHeaders;
        List<OmOrderHeaders> list = omOrderHeadersMapper.selectCustAndCompany(dto);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getHeaderId() != null) {
                    //查出对应的headerId的行信息
                    OmOrderLines omOrderLines = new OmOrderLines();
                    omOrderLines.setHeaderId(list.get(i).getHeaderId());
                    List<OmOrderLines> linesList = (List<OmOrderLines>) orderLinesService.findByHeaderId(omOrderLines);

                    Double totalPrice = 0.0;
                    if (linesList != null && !linesList.isEmpty()) {
                        for (int j = 0; j < linesList.size(); j++) {
                            totalPrice = totalPrice + linesList.get(j).getOrderdQuantity() * linesList.get(j).getUnitSellingPrice();
                        }
                    }
                    list.get(i).setTotalPrice(totalPrice);
                }
            }
        }
        return list;

    }

    @Override
    public List<OmOrderHeaders> batchSubmit(IRequest request, List<OmOrderHeaders> list) {

        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                OmOrderHeaders omOrderHeaders = list.get(i);
                //通过headerId 来判断是更新还是新增操作
                Long hearderId = omOrderHeaders.getHeaderId();
                if (hearderId == null || hearderId == 0) {
                    //是新增头的操作
                    //先增加头
                    String codeRule = "";
                    try {
                        codeRule = sysCodeRuleProcessService.getRuleCode("HAP_OM_ORDER_HEADER_S");
                        System.err.println("codeRule:  " + codeRule);
                    } catch (CodeRuleException e) {
                        e.printStackTrace();
                    }

//                    omOrderHeaders.setHeaderId(RuleCodeUtils.getTheNumberByRuleCode(codeRule));
                    omOrderHeaders.setOrderNumber(codeRule);
                    omOrderHeadersService.insertSelective(request, omOrderHeaders);
                    //mybatis保存成功后会回写这个对象，所以开始的对象中就有数据了
                    hearderId = omOrderHeaders.getHeaderId();
                    //再保存行
                    List<OmOrderLines> linesList = omOrderHeaders.getOmOrderLinesList();
                    //System.err.println("list 的长度:"+linesList.size());
                    if (linesList != null && !linesList.isEmpty()) {
                        for (int j = 0; j < linesList.size(); j++) {
                            //加入hearId值
                            System.err.println("进入了 for 循环");
                            linesList.get(j).setCompanyId(omOrderHeaders.getCompanyId());
                            linesList.get(j).setHeaderId(hearderId);
                        }
                    }
                    orderLinesService.myBatchSubmit(request, linesList);

                } else {
                    //是更新操作
                    System.err.println("头：更新操作");
                    List<OmOrderLines> linesList = omOrderHeaders.getOmOrderLinesList();
                    if (linesList != null && !linesList.isEmpty()) {
                        for (int j = 0; j < linesList.size(); j++) {
                            //加入hearId值
                            linesList.get(j).setCompanyId(omOrderHeaders.getCompanyId());
                            linesList.get(j).setHeaderId(hearderId);
                        }
                    }
                    orderLinesService.myBatchSubmit(request, linesList);
                }
            }
        }

        return list;

    }

    /**
     * 自定义删除头行的方法
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public int myBatchDelete(IRequest request, List<OmOrderHeaders> dto) throws Exception {
        int count = 0;
        if (dto!=null && !dto.isEmpty()){
            for (int i=0;i<dto.size();i++){
                OmOrderHeaders omOrderHeaders = dto.get(i);
                Long headerId = omOrderHeaders.getHeaderId();
                if (headerId == null){
                    throw new Exception("缺失主键");
                }
                //查询对应行
                OmOrderLines omOrderLines = new OmOrderLines();
                omOrderLines.setHeaderId(headerId);
                //根据对应值查出对应的行表
                List<OmOrderLines> omOrderLines1 = orderLinesService.select(request,omOrderLines,1,0);
                if(omOrderLines1!=null && !omOrderLines1.isEmpty()){
                    //批量删除行
                    orderLinesService.batchDelete(omOrderLines1);
                }
                //删除头
                int n= omOrderHeadersService.deleteByPrimaryKey(omOrderHeaders);
                count+=n;
            }
        }
        return count;
    }


}