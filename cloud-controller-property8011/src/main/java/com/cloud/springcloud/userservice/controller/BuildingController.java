package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Building;
import com.cloud.springcloud.userservice.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 房间信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/userservice/building")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @GetMapping(value = "/saveBuilding" ,name = "新增房间信息")
    public CommonResult saveBuilding(Building building){
        boolean b = buildingService.saveBuilding(building);
        if (b){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"false");
        }
    }


    @GetMapping(value = "/getBuilding/{pn}" ,name = "查询所有房间")
    public CommonResult<Page<Building>> getBuilding(@PathVariable("pn")Integer pn){
        return buildingService.getBuilding(pn);
    }

    @GetMapping(value = "/getBuildingForCode/{code}" ,name = "根据房间号查询房间")
    public CommonResult<Page<Building>> getBuildingForCode(@PathVariable("code") Integer code){
        return buildingService.getBuildingForCode(code);
    }
    @GetMapping(value = "/getBuildingForOwnerId/{id}" ,name = "根据用户id查询房间")
    public CommonResult<Page<Building>> getBuildingForOwnerId(@PathVariable("id") Integer id){
        return buildingService.getBuildingForOwnerId(id);
    }

    @GetMapping(value = "/updateforid" ,name = "根据id跟新")
    public CommonResult updateForId(Building building){
        return buildingService.updateForId(building);
    }

    @GetMapping(value = "/deleteForId/{ids}" ,name = "根据id删除一个或多个房间信息")
    public CommonResult deleteForId(@PathVariable("ids")String ids){

        if (ids.contains("-")){
            //批量删除
            List<Integer> del_ids =new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string :str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            return buildingService.deleteForArryId(del_ids);

        }else {
            Integer id = Integer.parseInt(ids);
            return   buildingService.deleteForId(id);
        }

    }

}

