package com.sjqcf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer code;//响应码,1为成功,0为失败
    private String msg;//响应信息
    private Object data;//响应数据

    public static Result success(){
        Result r = new Result();
        r.setCode(1);
        r.setMsg("success");
        return r;
    }

    public static Result success(Object data){
        Result r = new Result();
        r.code = 1;
        r.msg = "success";
        r.data = data;
        return r;
    }

    public static Result error(String msg){
        Result r = new Result();
        r.code = 0;
        r.msg = msg;
        return r;
    }
}
