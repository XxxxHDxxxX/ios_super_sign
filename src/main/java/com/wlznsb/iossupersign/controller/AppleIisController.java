package com.wlznsb.iossupersign.controller;

import com.wlznsb.iossupersign.dto.UserDto;
import com.wlznsb.iossupersign.entity.AppleIis;
import com.wlznsb.iossupersign.entity.User;
import com.wlznsb.iossupersign.service.AppleIisService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * iis证书操作控制器
 */
@RestController
@RequestMapping(value = "/iis")
@Validated
public class AppleIisController {

    @Autowired
    private AppleIisService appleIisService;

    @RequestMapping(value = "/addIis",method = RequestMethod.POST)
    public Map<String,Object> addIis(@RequestParam @NotEmpty String iis, @RequestParam @NotEmpty String kid,@RequestParam  MultipartFile p8, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        appleIisService.add(iis, kid, p8, request);
        map.put("code", 0);
        map.put("message", "添加成功");
        return map;
    }

    @RequestMapping(value = "/deleIis",method = RequestMethod.POST)
    public Map<String,Object> deleIis(@RequestParam @NotEmpty String iis,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        appleIisService.dele(iis,request);
        map.put("code", 0);
        map.put("message", "删除成功");
        return map;
    }

    @RequestMapping(value = "/updateStartOrStatus",method = RequestMethod.POST)
    public Map<String,Object> updateStartOrStatus(@RequestParam @NotEmpty String type, @RequestParam @NotEmpty String iis, @RequestParam @Range(max = 1,message = "参数错误") int s, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        appleIisService.updateStartOrStatus(type, iis, s,request);
        map.put("code", 0);
        map.put("message", "修改成功");
        return map;
    }

    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public Map<String,Object> queryAll(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        List<AppleIis> appleIisList = appleIisService.queryAll(request);
        map.put("code", 0);
        map.put("message", "查询成功");
        map.put("data", appleIisList);
        return map;
    }

    @RequestMapping(value = "/queryAccount",method = RequestMethod.GET)
    public Map<String,Object> queryAccount(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getAccount() + "111111111");
        List<AppleIis> appleIisList = appleIisService.queryAccount(user.getAccount(),request);
        map.put("code", 0);
        map.put("message", "查询成功");
        map.put("data", appleIisList);
        return map;
    }


    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Map<String,Object> queryAccount(@RequestParam @NotEmpty String iis,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        AppleIis appleIis = appleIisService.query(iis, request);
        map.put("code", 0);
        map.put("message", "查询成功");
        map.put("data", appleIis);
        return map;
    }


}