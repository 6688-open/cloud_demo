package com.dj.cloud.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.cloud.domain.Storage;
import com.dj.cloud.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

}
