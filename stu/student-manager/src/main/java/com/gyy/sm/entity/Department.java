package com.gyy.sm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Department
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Integer id;
    private String departmentName;
    private String logo;

}
