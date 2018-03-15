package com.project.sdk.service.adapter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.project.sdk.common.ExecuteResult;
import com.project.sdk.common.Pager;
import com.project.sdk.common.Trans;
import com.project.sdk.dto.log.InterfaceLogDto;
import com.project.sdk.export.dto.log.InterfaceLogExportDto;
import com.project.sdk.export.service.log.InterfaceLogExportService;
import com.project.sdk.service.InterfaceLogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2017/9/4.
 */
@Service("interfaceLogExportService")
public class InterfaceLogExportAdapter implements InterfaceLogExportService {
  @Reference
  private InterfaceLogService interfaceLogService;

  @Override
  public ExecuteResult<InterfaceLogExportDto> addInterfaceLogInfo(
          InterfaceLogExportDto interfaceLogExportDto) {
    ExecuteResult<InterfaceLogExportDto> result = new ExecuteResult<>();
    try {
      InterfaceLogDto interfaceLogDto = new InterfaceLogDto();
      interfaceLogDto = (InterfaceLogDto) Trans.transBeanToBeanDto(
              interfaceLogExportDto, interfaceLogDto);
      interfaceLogService.addInterfaceLogInfo(interfaceLogDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<InterfaceLogExportDto> updateInterfaceLog(
          InterfaceLogExportDto interfaceLogExportDto) {
    ExecuteResult<InterfaceLogExportDto> result = new ExecuteResult<>();
    try {
      InterfaceLogDto interfaceLogDto = new InterfaceLogDto();
      interfaceLogDto = (InterfaceLogDto) Trans.transBeanToBeanDto(
              interfaceLogExportDto, interfaceLogDto);
      interfaceLogService.updateInterfaceLog(interfaceLogDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public Pager<InterfaceLogExportDto> findInterfaceLogs(
          Pager pager, InterfaceLogExportDto interfaceLogExportDto) {
    Pager<InterfaceLogExportDto> pager1 = new Pager<>();
    try {
      InterfaceLogDto interfaceLogDto = new InterfaceLogDto();
      interfaceLogDto = (InterfaceLogDto) Trans.transBeanToBeanDto(
              interfaceLogExportDto, interfaceLogDto);
      Pager<InterfaceLogDto> logDtos = interfaceLogService.findInterfaceLogs(pager,interfaceLogDto);
      pager1.setTotalCount(logDtos.getTotalCount());
      List<InterfaceLogExportDto> logExportDtos = (List) Trans.transListBeanToBeanDto(
              logDtos.getRecords(),new InterfaceLogExportDto());
      pager1.setRecords(logExportDtos);
    } catch (Exception e) {
      pager1.setErrorMessage(e.getMessage());
    }
    return pager1;
  }

  @Override
  public ExecuteResult<InterfaceLogExportDto> getInterfaceLogById(Long id) {
    ExecuteResult<InterfaceLogExportDto> result = new ExecuteResult<>();
    try {
      InterfaceLogDto interfaceLogDto = interfaceLogService.getInterfaceLogById(id);
      InterfaceLogExportDto interfaceLogExportDto = new InterfaceLogExportDto();
      interfaceLogExportDto = (InterfaceLogExportDto) Trans.transBeanToBeanDto(
              interfaceLogDto, interfaceLogExportDto);
      result.setResult(interfaceLogExportDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }
}
