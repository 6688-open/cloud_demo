package com.dj.cloud.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.cloud.domain.Account;
import com.dj.cloud.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
