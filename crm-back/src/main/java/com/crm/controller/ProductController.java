package com.crm.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.Product;
import com.crm.service.ProductService;
import com.crm.vo.AjaxResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 产品表控制层
 * */

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    /*
    * 查询全部产品
    * */
    //设置访问路由的路径
    @RequestMapping("/product")
    @ResponseBody
    public AjaxResponse findAll(Integer currenPage,Integer pageSize){
        System.out.println("currenPage"+currenPage+"---"+"pageSize"+pageSize);
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Product> list = this.productService.getAll();
        map.put("total",pg.getTotal());
        map.put("list",list);
        System.out.println("map:"+map);
        return AjaxResponse.success(map);
    }


    /*
    * 新增一条产品
    *
    *
       @RequestMapping(value="/addProduct",method = RequestMethod.POST)
    public Product addProdcut(@RequestBody String a) {
        JSONObject jsonObject = JSON.parseObject(a);
        System.out.println("json:" + jsonObject);
        String ss = jsonObject.getString("ss");
        Product product = JSON.parseObject(ss, Product.class);
        System.out.println("=====================" + product.toString());
        return productService.insert(product);
    }
    * */
    @RequestMapping(value="/addProduct",method = RequestMethod.POST)
    public Product addProdcut(@RequestBody Product product) {
        //System.out.println("=====================" + product.toString());
        return productService.insert(product);
    }


    /*
    *删除一个产品
    *  @RequestMapping(value = "/delProduct/{id}",method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id){
       boolean result=productService.deleteById(id);
       if(result=true){
           return "删除成功";
       }else{
           return "删除失败";
       }

    }
    * */
    @DeleteMapping("/delProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteById(id);
        return "delok";

    }

    /*
    *通过主键id修改产品信息
    * */

    @PutMapping("/updateProduct")
    public AjaxResponse updatePro(@RequestBody @Valid Product product){

          productService.update(product);
          //System.out.println("=================="+product);
          return AjaxResponse.success(product);
    }


}
