package com.mytest.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author liyn
 * @since 2020-06-30 15:06:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -60675008630616007L;

    private Long id;

    private String serial;

}