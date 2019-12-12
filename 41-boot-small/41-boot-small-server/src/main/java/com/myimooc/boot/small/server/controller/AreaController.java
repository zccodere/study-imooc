package com.myimooc.boot.small.server.controller;

import com.myimooc.boot.small.server.po.Area;
import com.myimooc.boot.small.server.service.AreaService;
import com.myimooc.boot.small.server.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <br>
 * 标题: 区域控制器<br>
 * 描述: 控制器类<br>
 *
 * @author zc
 * @date 2018/04/17
 */
@RestController
@RequestMapping("/superadmin/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/list")
    public BaseResponse list() {
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.putData("areaList", this.areaService.listAll());
        return response;
    }

    @GetMapping("/find")
    public BaseResponse findById(Integer areaId) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.putData("area", this.areaService.findById(areaId));
        return response;
    }

    @PostMapping("/create")
    public BaseResponse create(@RequestBody Area area) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(this.areaService.create(area));
        return response;
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestBody Area area) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(this.areaService.update(area));
        return response;
    }

    @GetMapping("/remove")
    public BaseResponse remove(Integer areaId) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(this.areaService.delete(areaId));
        return response;
    }
}
