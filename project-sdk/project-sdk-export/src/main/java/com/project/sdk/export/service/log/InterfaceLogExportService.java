package com.project.sdk.export.service.log;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.common.Pager;
import com.project.sdk.export.dto.log.InterfaceLogExportDto;

/**
 * Created by sun on 2017/9/4.
 */
public interface InterfaceLogExportService {
  /**
   * 添加接口日志.
   *
   * @param orderDto orderDto
   * @return InterfaceLogExportDto.id
   */
  public ExecuteResult<InterfaceLogExportDto> addInterfaceLogInfo(InterfaceLogExportDto orderDto);

  /**
   * 修改接口日志.
   *
   * @param orderDto orderDto
   * @return InterfaceLogExportDto
   */
  public ExecuteResult<InterfaceLogExportDto> updateInterfaceLog(InterfaceLogExportDto orderDto);

  /**
   * 根据InterfaceLogExportDto获取日志列表.
   * @param pager pager
   * @param orderDto orderDto
   * @return Pager
   */
  public Pager<InterfaceLogExportDto> findInterfaceLogs(Pager pager, InterfaceLogExportDto orderDto);



  /**
   * 通过id获取日志.
   * @param id orderId
   * @return InterfaceLogExportDto
   */
  public ExecuteResult<InterfaceLogExportDto> getInterfaceLogById(Long id);

}
