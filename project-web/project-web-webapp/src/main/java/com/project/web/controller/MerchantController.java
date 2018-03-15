package com.project.web.controller;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.web.service.MerchantService;
import java.util.List;
import javax.annotation.Resource;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
@Controller
@RequestMapping("merchant")
public class MerchantController {
  @Resource
  private MerchantService merchantService;

  /**
     * .
     * @param merchantExportDto merchantExportDto
     * @return String
  */
  @ResponseBody
  @RequestMapping("/queryListMerchant")
  public String queryListMerchant(MerchantExportDto merchantExportDto) {
    ExecuteResult<List<MerchantExportDto>> result = new ExecuteResult<List<MerchantExportDto>>();
    try {
      result = merchantService.queryList(merchantExportDto);
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }


  /**
   * 分页查询商家.
   * @param pager  pager
   * @param merchantExportDto  merchantExportDto
   * @return
   * Created by liq
 */
  @ResponseBody
  @RequestMapping("/queryList")
  public String queryList( Pager pager,  MerchantExportDto merchantExportDto) {
    Pager<MerchantExportDto> result = new Pager<MerchantExportDto>();
    try {
      //merchantExportDto.setLongitude("120.38264");
      //merchantExportDto.setLatitude("36.067082");
      result = merchantService.queryPagerList(pager,merchantExportDto);
    } catch (Exception e) {
      result.setResultMsg(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }
}
