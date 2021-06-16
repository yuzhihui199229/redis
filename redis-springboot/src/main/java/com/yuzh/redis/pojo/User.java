package com.yuzh.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//在企业中，我们所有得实体类都会序列化
public class User implements Serializable {
    private String name;
    private Integer age;
}
