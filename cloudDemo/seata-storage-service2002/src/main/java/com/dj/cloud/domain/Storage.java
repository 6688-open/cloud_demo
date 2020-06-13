package com.dj.cloud.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_storage")
public class Storage {


    @TableId(type = IdType.AUTO)
    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
