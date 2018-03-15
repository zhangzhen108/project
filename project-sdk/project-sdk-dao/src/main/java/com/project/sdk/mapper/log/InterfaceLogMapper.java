package com.project.sdk.mapper.log;

import com.project.sdk.common.Pager;

import com.project.sdk.dto.log.InterfaceLogDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sun on 2017/9/4.
 */
public interface InterfaceLogMapper {
  /**
   * 新增order.
   *
   * @param interfaceLogDto interfaceLogDto
   * @return InterfaceLogDto
   */
  int addInterfaceLog(InterfaceLogDto interfaceLogDto);

  /**
   * 修改order.
   *
   * @param interfaceLogDto interfaceLogDto
   * @return int
   */
  int updateInterfaceLog(@Param("entity") InterfaceLogDto interfaceLogDto);

  /**
   * 查询order列表.
   *
   * @return List
   */
  List<InterfaceLogDto> findInterfaceLogs(@Param("page") Pager page, @Param("entity") InterfaceLogDto interfaceLogDto);

  /**
   * 根据id获取order.
   *
   * @param id id
   * @return InterfaceLogDto
   */
  InterfaceLogDto queryById(@Param("id") Long id);

  /**
   * <p>Discription:[查询数量]</p>.
   * Created on
   *
   * @param interfaceLogDto 对象
   * @return 返回总数
   * @author:sun
   */
  int queryCount(@Param("entity") InterfaceLogDto interfaceLogDto);
}
