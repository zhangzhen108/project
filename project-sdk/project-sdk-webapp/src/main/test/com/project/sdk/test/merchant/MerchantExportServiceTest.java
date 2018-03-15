package com.project.sdk.test.merchant;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.sdk.export.service.merchant.MerchantExportService;
import com.project.sdk.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * .
 * Created by liq on 2017/7/31.
 */
public class MerchantExportServiceTest extends BaseTest {

    @Resource
    private MerchantExportService merchantExportService;

    /**
     * 分页查询方法测试
     */
    @Test
    public void queryPage(){
        MerchantExportDto merchantDto = new MerchantExportDto();
        //merchantDto.setId(1);
        Pager<MerchantExportDto> result = this.merchantExportService.queryPageList(new Pager(),merchantDto);
        System.out.println(JSON.toJSON(result));
    }

    /**
     * 条件查询方法测试
     */
    @Test
    public void queryBy(){
        MerchantExportDto merchantDto = new MerchantExportDto();
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        merchantDto.setIds(lists);
        ExecuteResult<List<MerchantExportDto>> result = this.merchantExportService.queryMerchantList(merchantDto);
        System.out.println(JSON.toJSON(result));
    }
    /**
     * 根据id查询
     */
    @Test
    public void queryById(){
        ExecuteResult<MerchantExportDto> result = this.merchantExportService.queryMerchantDtoById(1);
        System.out.println(JSON.toJSON(result));
    }

    /**
     * 保存测试
     */
    @Test
    public void addMerchant(){
        MerchantExportDto merchantExportDto = new MerchantExportDto();
        merchantExportDto.setName("测试保存");
        ExecuteResult<MerchantExportDto> result = this.merchantExportService.addMerchantDto(merchantExportDto);
        System.out.println(JSON.toJSON(result));
    }

    /**
     * 修改测试
     */
    @Test
    public void updateMerchant(){
        MerchantExportDto merchantExportDto = new MerchantExportDto();
        merchantExportDto.setName("测试修改");
        merchantExportDto.setId(8);
        ExecuteResult<String> result = this.merchantExportService.updateMerchantDtoById(merchantExportDto);
        System.out.println(JSON.toJSON(result));
    }
}
