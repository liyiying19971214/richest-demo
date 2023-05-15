package com.example.richest.common;

import lombok.Data;

@Data
public class Result {
 private Integer code;
 private String msg;
 private Object data;
 public static Result succ(Object data) {
 Result m = new Result();
 m.setCode(200);
 m.setData(data);
 m.setMsg("操作成功");
 return m;
 }
 public static Result succ(String mess, Object data) {
 Result m = new Result();
 m.setCode(200);
 m.setData(data);
 m.setMsg(mess);
 return m;
 }
 public static Result fail(String mess) {
 Result m = new Result();
 m.setCode(-1);
 m.setData(null);
 m.setMsg(mess);
 return m;
 }
 public static Result fail(String mess, Object data) {
 Result m = new Result();
 m.setCode(-1);
 m.setData(data);
 m.setMsg(mess);
 return m;
 }



}
