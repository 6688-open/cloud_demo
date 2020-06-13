package com.dj.cloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.cloud.domain.CommentResult;
import com.dj.cloud.domain.Storage;
import com.dj.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/storage/")
public class StorageController {


    @Autowired
    private StorageService storageService;

    @GetMapping("test")
    public CommentResult test(){
        return new CommentResult(200, "success");
    }

    @PostMapping("descCount")
    CommentResult descCount(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){

        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        Storage storage = storageService.getOne(queryWrapper);

        storage.setTotal(storage.getTotal()-count);
        storage.setUsed(storage.getUsed()+count);
        storage.setResidue(storage.getResidue()-count);
        storageService.updateById(storage);
        return new CommentResult(200, "success");
    }
}
