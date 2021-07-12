package com.crm.controller;
import com.crm.entity.Product;
import com.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Product> findAll(){
        return this.productService.getAll();
    }


    /*
    * 新增一条产品
    * */

    @RequestMapping(value="/addProduct",method = RequestMethod.POST)
    public Product addProdcut(Product product){
        return productService.insert(product);
    }

    /*
    *删除一个产品
    * */
    @RequestMapping(value = "/delProduct/{id}",method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id){
       boolean result=productService.deleteById(id);
       if(result=true){
           return "删除成功";
       }else{
           return "删除失败";
       }

    }

    /*
    *通过主键id修改产品信息
    * */
//    @RequestMapping(value = "/updateProduct/{id}",method = RequestMethod.PUT)
//    public String updatePro(@PathVariable("id") @RequestBody  Product product){
//       productService.update(product);
//       return "Success";
//    }

}
