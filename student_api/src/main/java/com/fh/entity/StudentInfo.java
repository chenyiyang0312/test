package com.fh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("s_student")
@Data
public class StudentInfo {
   @TableId(value = "id",type = IdType.AUTO)
   private Integer  id;
   @TableField("name")
   private String name;
    @TableField("age")
   private Integer age;
    @TableField("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date birthday;
    @TableField("address")
   private String address;
    @TableField("img")
   private String img;
    @TableField("isDel")
   private Integer isDel;
    @TableField("ip")
   private String ip;

}
