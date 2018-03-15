package com.project.sdk.export.dto.food;

import java.io.Serializable;
import java.util.List;

/**食品类型类
 * Created by Administrator on 2017/8/5.
 */
public class FoodTypeDto implements Serializable{


    private  Integer id;
    private String code;
    private String name;
    private String merchantid;
    private List<FoodDto> foodList;

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodDto> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodDto> foodList) {
        this.foodList = foodList;
    }
}
