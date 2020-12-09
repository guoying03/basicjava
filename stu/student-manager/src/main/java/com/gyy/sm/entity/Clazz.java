package com.gyy.sm.entity;

import com.sun.org.apache.bcel.internal.generic.RET;
import lombok.*;

import javax.jws.soap.SOAPMessageHandler;

/**
 * @ClassName Clazz
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/23
 **/
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {

    private Integer id;
    private Integer departmentId;
    private String className;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId){
        this.departmentId = departmentId;
    }

    public String getClassName(){
        return className;
    }

    public void setClassName(String className){
        this.className = className;
    }

    @Override
    public String toString(){
        return className;
    }
}
