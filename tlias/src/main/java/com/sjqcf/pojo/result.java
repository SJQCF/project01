package com.sjqcf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class result {

    private Integer code;//响应码,1为成功,0为失败
    private String msg;//响应信息
    private Object data;//响应数据

    public static result success(){
        result r = new result();
        r.setCode(1);
        r.setMsg("success");
        return r;
    }

    public static result success(Object data){
        result r = new result();
        r.code = 1;
        r.msg = "success";
        r.data = data;
        return r;
    }

    public static result error(String msg){
        result r = new result();
        r.code = 0;
        r.msg = msg;
        return r;
    }
}
