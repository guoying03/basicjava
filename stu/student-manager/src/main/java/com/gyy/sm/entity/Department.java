package com.gyy.sm.entity;

import lombok.*;

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
@Setter
@Getter
public class Department  {
    private Integer id;
    private String departmentName;
    private String logo;

    @Override
//    @Builder(toBuilder = true)
    public String toString() {
        return this.departmentName;
    }

}
