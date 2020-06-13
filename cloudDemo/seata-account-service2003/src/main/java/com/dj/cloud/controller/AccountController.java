package com.dj.cloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.cloud.domain.Account;
import com.dj.cloud.domain.CommentResult;
import com.dj.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account/")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping("test")
    public CommentResult test(){
        return new CommentResult(200, "success");
    }


    @PostMapping("descMoney")
    public CommentResult descMoney(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){

        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Account account = accountService.getOne(queryWrapper);

        account.setTotal(account.getTotal().subtract(money));
        account.setUsed(account.getUsed().add(money));
        account.setResidue(account.getResidue().subtract(money));
        accountService.updateById(account);
        return new CommentResult(200, "success");
    }
}
