package com.dj.cloud.feign;

import com.dj.cloud.domain.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 账户diaoyong
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignService {

    @PostMapping("/account/descMoney")
    CommentResult descMoney(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
