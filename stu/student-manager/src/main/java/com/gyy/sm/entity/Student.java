package com.gyy.sm.entity;

import lombok.*;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/26
 **/
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String id;
    private Integer classId;
    private String studentName;
    private String phone;
    private Short gender;
    private Date birthday;
    private String avatar;
    private String address;
}
