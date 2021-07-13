package com.crm.service;

import com.crm.dao.HandleProductDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 出入库单明细service层
 */
@Service
public class HandleProductService {
    @Autowired
    private HandleProductDao handleProductDao;

    /**
     * 查询出入库单下所有的产品明细记录
     */
    public PageInfo<Map> findAllHandleProduct(int page,int size){
        PageHelper.startPage(page,size);
        List<Map> handleProducts = handleProductDao.findAllHandleProduct();
        return new PageInfo<>(handleProducts);
    }
}
