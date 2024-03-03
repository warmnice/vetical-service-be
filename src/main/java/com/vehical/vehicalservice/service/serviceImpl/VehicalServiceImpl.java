package com.vehical.vehicalservice.service.serviceImpl;

import com.vehical.vehicalservice.domain.Vehical;
import com.vehical.vehicalservice.repository.VehicalDao;
import com.vehical.vehicalservice.service.VehicalService;
import jakarta.annotation.Resource;
import com.vehical.vehicalservice.result.Exception;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicalServiceImpl implements VehicalService {
    @Resource
    private VehicalDao vehicalDao;
    // 查询所有车辆信息
    public List<Vehical> allVehical() {
        List<Vehical> allVehical = vehicalDao.findAll();
        return allVehical;
    }
    // 查询特定车辆信息
    public List<Vehical> oneVehical(String vehicalName) {
        return vehicalDao.findAllByCname(vehicalName);
    }
    // 添加车辆
    public void addVehical(String cname, String ccolor, int cprice, int cage) {
        if(vehicalDao.findByCnameAndAndCcolorAndAndCpriceAndAndCage(cname, ccolor, cprice, cage) != null) {
            throw new Exception("车辆已存在");
        }
        Vehical newVehical = new Vehical(cname, ccolor, cprice, cage);
        vehicalDao.save(newVehical);
    }
    // 修改车辆
    public void upgradeVehical(int cid, String cname, String ccolor, int cprice, int cage) {
        Vehical vehical = vehicalDao.findByCid(cid);
        if (vehical == null) {
            throw new Exception("车辆不存在");
        }
        vehical.setCname(cname);
        vehical.setCcolor(ccolor);
        vehical.setCprice(cprice);
        vehical.setCage(cage);
        vehicalDao.save(vehical);
    }
    // 删除车辆
    public void deleteVehical(int[] ids) {
        for (int cid : ids) {
            vehicalDao.deleteByCid(cid);

        }
    }
}
