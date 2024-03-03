package com.vehical.vehicalservice.controller;

import com.vehical.vehicalservice.domain.Vehical;
import com.vehical.vehicalservice.request.NewVehical;
import com.vehical.vehicalservice.service.VehicalService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class VehicalController {
    @Resource
    private VehicalService vehicalService;
    // 查询所有车辆信息
    @GetMapping("/getAllVehical")
    public ResponseEntity<List<Vehical>> allVehicalController() {
        List<Vehical> allVehical = vehicalService.allVehical();
        if (allVehical != null) {
            return ResponseEntity.ok(allVehical);
        }
        return ResponseEntity.status(404).body(null);
    }
    // 查询特定车辆信息
    @GetMapping("/getOneVehical/{vehicalName}")
    public ResponseEntity<List<Vehical>> oneVehicalController(@PathVariable String vehicalName) {
        List<Vehical> oneVehical = vehicalService.oneVehical(vehicalName);
        if (oneVehical != null) {
            return ResponseEntity.ok(oneVehical);
        }
        return ResponseEntity.status(404).body(null);
    }
    // 添加车辆
    @PostMapping("/addVehical")
    public ResponseEntity<?> addVehicalController(@RequestBody NewVehical newVehical) {
        String cname = newVehical.getCarName();
        String ccolor = newVehical.getCarColor();
        int cprice = newVehical.getCarPrice();
        int cage = newVehical.getCarAge();
        System.out.println(cname+ccolor+cprice+cage);
        if (Objects.equals(cname, "") || Objects.equals(ccolor, "") || cprice <= 0 || cage <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            vehicalService.addVehical(cname, ccolor, cprice, cage);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("车辆已存在");
        }
    }
    // 修改车辆
    @PutMapping("/upgradeVehical")
    public ResponseEntity<?> upgradeVehicalController(@RequestBody Vehical subVehical) {
        int cid  = subVehical.getCid();
        String cname = subVehical.getCname();
        String ccolor = subVehical.getCcolor();
        int cprice = subVehical.getCprice();
        int cage = subVehical.getCage();
        if (cid <= 0 || Objects.equals(cname, "") || Objects.equals(ccolor, "") || cprice <= 0 || cage <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            vehicalService.upgradeVehical(cid, cname, ccolor, cprice, cage);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("车辆不存在");
        }
    }
    // 删除车辆
    @DeleteMapping("/deleteVehical/{ids}")
    @Transactional
    public ResponseEntity<?> deleteVehicalController(@PathVariable String ids) {
        // 参数校验
        if (Objects.equals(ids, "")) {
            return ResponseEntity.badRequest().build();
        }
        // 使用 split 方法拆分字符串
        String[] temp = ids.split(",");
        // 创建整数数组
        int[] vehicalIds = new int[temp.length];
        // 使用循环将字符串数组转换为整数数组
        for (int i = 0; i < temp.length; i++) {
            vehicalIds[i] = Integer.parseInt(temp[i]);
        }
        vehicalService.deleteVehical(vehicalIds);
        return ResponseEntity.ok(null);
    }

}
