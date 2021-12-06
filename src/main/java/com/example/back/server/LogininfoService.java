package com.example.back.server;

import com.example.back.entity.Logininfo;
import com.example.back.entity.User;
import com.example.back.repository.LogininfoReponsitory;
import com.example.back.utils.IpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LogininfoService {
    @Autowired
    private LogininfoReponsitory logininfoReponsitory;

    public List<Logininfo> findAll()
    {
        return logininfoReponsitory.findAll();
    }

    public void AddLogininfo(HttpServletRequest request, Integer uid)
    {
        Logininfo logininfo = new Logininfo();
        logininfo.setLoadip(IpAddress.getIpAddress(request));
        logininfo.setUid(uid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logininfo.setLoadtime(sdf.format(new Date()));
        logininfoReponsitory.save(logininfo);
    }
}
