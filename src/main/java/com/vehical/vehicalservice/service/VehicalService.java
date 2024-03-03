package com.vehical.vehicalservice.service;
import com.vehical.vehicalservice.domain.Vehical;

import java.util.List;

public interface VehicalService {
    // 查询所有车辆信息
    List<Vehical> allVehical();
    // 查询特定车辆信息
    List<Vehical> oneVehical(String vehicalName);
    // 添加车辆
    void addVehical(String cname, String ccolor, int cprice, int cage);
    // 修改车辆
    void upgradeVehical(int cid, String cname, String ccolor, int cprice, int cage);
    // 删除车辆
    void deleteVehical(int[] ids);
}
