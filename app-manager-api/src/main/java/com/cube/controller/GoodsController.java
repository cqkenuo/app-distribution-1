package com.cube.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cube.entity.GoodsEntity;
import com.cube.service.GoodsService;
import com.cube.common.utils.PageUtils;
import com.cube.common.utils.R;



/**
 * 
 *
 * @author tututu
 * @email 289911401@qq.com
 * @date 2019-11-20 17:35:42
 */
@RestController
@RequestMapping("cube/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        GoodsEntity goods = goodsService.getById(id);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsEntity goods){
        goodsService.save(goods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsEntity goods){
        goodsService.updateById(goods);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
        goodsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
