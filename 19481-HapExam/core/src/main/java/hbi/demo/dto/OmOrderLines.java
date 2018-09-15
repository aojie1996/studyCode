package hbi.demo.dto;

/**Auto Generated By Hap Code Generator**/
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Table;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
@ExtensionAttribute(disable=true)
@Table(name = "hap_om_order_lines")
public class OmOrderLines extends BaseDTO {

     public static final String FIELD_LINE_ID = "lineId";
     public static final String FIELD_HEADER_ID = "headerId";
     public static final String FIELD_LINE_NUMBER = "lineNumber";
     public static final String FIELD_INVENTORY_ITEM_ID = "inventoryItemId";
     public static final String FIELD_ORDERD_QUANTITY = "orderdQuantity";
     public static final String FIELD_ORDER_QUANTITY_UOM = "orderQuantityUom";
     public static final String FIELD_UNIT_SELLING_PRICE = "unitSellingPrice";
     public static final String FIELD_DESCRIPTION = "description";
     public static final String FIELD_COMPANY_ID = "companyId";
     public static final String FIELD_ADDITION1 = "addition1";
     public static final String FIELD_ADDITION2 = "addition2";
     public static final String FIELD_ADDITION3 = "addition3";
     public static final String FIELD_ADDITION4 = "addition4";
     public static final String FIELD_ADDITION5 = "addition5";


     @Id
     @GeneratedValue
     private Long lineId; //订单行ID

     @NotNull
     private Long headerId; //订单头ID

     @NotNull
     private Long lineNumber; //行号

     @NotNull
     private Long inventoryItemId; //产品ID

     @NotNull
     private Long orderdQuantity; //数量

     @NotEmpty
     @Length(max = 30)
     private String orderQuantityUom; //产品单位

     @NotNull
     private Long unitSellingPrice; //销售单价

     @NotEmpty
     @Length(max = 240)
     private String description; //备注

     @NotNull
     private Long companyId; //公司ID

     @Length(max = 150)
     private String addition1; //附加信息1

     @Length(max = 150)
     private String addition2; //附加信息2

     @Length(max = 150)
     private String addition3; //附加信息3

     @Length(max = 150)
     private String addition4; //附加信息4

     @Length(max = 150)
     private String addition5; //附加信息5
     @Transient
     private String itemCode;//物料编码
     @Transient
     private String itemDescription;//物料描述

    //加入两个字段 ，用于行信息的展示
     @Transient
     private String itemUom;//物料单位

     @Transient//数据库没有想要的字段，加上这个注解
     private Double price;//每个订单的金额

     public String getItemUom() {
        return itemUom;
     }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLineId(Long lineId){
         this.lineId = lineId;
     }

     public Long getLineId(){
         return lineId;
     }

     public void setHeaderId(Long headerId){
         this.headerId = headerId;
     }

     public Long getHeaderId(){
         return headerId;
     }

     public void setLineNumber(Long lineNumber){
         this.lineNumber = lineNumber;
     }

     public Long getLineNumber(){
         return lineNumber;
     }

     public void setInventoryItemId(Long inventoryItemId){
         this.inventoryItemId = inventoryItemId;
     }

     public Long getInventoryItemId(){
         return inventoryItemId;
     }

     public void setOrderdQuantity(Long orderdQuantity){
         this.orderdQuantity = orderdQuantity;
     }

     public Long getOrderdQuantity(){
         return orderdQuantity;
     }

     public void setOrderQuantityUom(String orderQuantityUom){
         this.orderQuantityUom = orderQuantityUom;
     }

     public String getOrderQuantityUom(){
         return orderQuantityUom;
     }

     public void setUnitSellingPrice(Long unitSellingPrice){
         this.unitSellingPrice = unitSellingPrice;
     }

     public Long getUnitSellingPrice(){
         return unitSellingPrice;
     }

     public void setDescription(String description){
         this.description = description;
     }

     public String getDescription(){
         return description;
     }

     public void setCompanyId(Long companyId){
         this.companyId = companyId;
     }

     public Long getCompanyId(){
         return companyId;
     }

     public void setAddition1(String addition1){
         this.addition1 = addition1;
     }

     public String getAddition1(){
         return addition1;
     }

     public void setAddition2(String addition2){
         this.addition2 = addition2;
     }

     public String getAddition2(){
         return addition2;
     }

     public void setAddition3(String addition3){
         this.addition3 = addition3;
     }

     public String getAddition3(){
         return addition3;
     }

     public void setAddition4(String addition4){
         this.addition4 = addition4;
     }

     public String getAddition4(){
         return addition4;
     }

     public void setAddition5(String addition5){
         this.addition5 = addition5;
     }

     public String getAddition5(){
         return addition5;
     }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
