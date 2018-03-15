package com.project.sdk.service.impl;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.log.InterfaceLogDto;
import com.project.sdk.mapper.log.InterfaceLogMapper;
import com.project.sdk.service.InterfaceLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * OrderService实现.
 * Created by sun on 2017/7/12.
 */
@Service
public class InterfaceLogServiceImpl implements InterfaceLogService {
  @Resource
  private InterfaceLogMapper interfaceLogMapper;

  @Override
  public int addInterfaceLogInfo(InterfaceLogDto interfaceLogDto) {
    return interfaceLogMapper.addInterfaceLog(interfaceLogDto);
  }

  @Override
  public int updateInterfaceLog(InterfaceLogDto interfaceLogDto) {
    return interfaceLogMapper.updateInterfaceLog(interfaceLogDto);
  }

  @Override
  public Pager<InterfaceLogDto> findInterfaceLogs(Pager pager, InterfaceLogDto interfaceLogDto) {
    Pager<InterfaceLogDto> pager1 = new Pager<>();
    List<InterfaceLogDto> logDtos = interfaceLogMapper.findInterfaceLogs(pager,interfaceLogDto);
    pager1.setTotalCount(interfaceLogMapper.queryCount(interfaceLogDto));
    pager1.setRecords(logDtos);
    return pager1;
  }

  @Override
  public InterfaceLogDto getInterfaceLogById(Long id) {
    return interfaceLogMapper.queryById(id);
  }
}
