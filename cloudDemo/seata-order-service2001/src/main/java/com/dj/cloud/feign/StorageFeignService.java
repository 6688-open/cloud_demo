package com.dj.cloud.feign;

import com.dj.cloud.domain.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignService {


        @PostMapping("/storage/descCount")
        CommentResult descCount(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
