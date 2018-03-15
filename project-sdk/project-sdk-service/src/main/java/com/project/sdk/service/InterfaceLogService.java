package com.project.sdk.service;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.log.InterfaceLogDto;


/**
 * InterfaceLogService.
 * Created by sun on 2017/7/12.
 */
public interface InterfaceLogService {

  /**
   * 添加接口日志.
   *
   * @param orderDto orderDto
   * @return InterfaceLogDto.id
   */
  public int addInterfaceLogInfo(InterfaceLogDto orderDto);
  


  /**
   * 修改接口日志.
   *
   * @param orderDto orderDto
   * @return InterfaceLogDto
   */
  public int updateInterfaceLog(InterfaceLogDto orderDto);

  /**
   * 根据InterfaceLogDto获取日志列表.
   * @param pager pager
   * @param orderDto orderDto
   * @return Pager
   */
  public Pager<InterfaceLogDto> findInterfaceLogs(Pager pager, InterfaceLogDto orderDto);



  /**
   * 通过id获取日志.
   * @param id orderId
   * @return InterfaceLogDto
   */
  public InterfaceLogDto getInterfaceLogById(Long id);

  
}
