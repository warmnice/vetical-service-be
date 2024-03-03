package com.vehical.vehicalservice.repository;
import com.vehical.vehicalservice.domain.Vehical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicalDao extends JpaRepository<Vehical, Integer> {
    // 查找所有的汽车记录
    List<Vehical> findAll();

    // 通过汽车ID寻找对应记录
    Vehical findByCid(int cid);
    // 通过汽车名称查找所有记录
    List<Vehical> findAllByCname(String cname);
    // 验证某条记录是否存在
    Vehical findByCnameAndAndCcolorAndAndCpriceAndAndCage(String cname, String ccolor, int cprice, int cage);
    // 通过汽车ID删除对应记录
    void deleteByCid(int cid);
}
