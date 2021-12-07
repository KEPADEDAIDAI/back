package com.example.back.server;

import com.example.back.entity.Usertemp;
import com.example.back.repository.UsertempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UsertempService {
    @Autowired
    private UsertempRepository usertempRepository;
    @Autowired
    private UserService userService;
    public void register(String mail)
    {
        Usertemp usertemp = new Usertemp();
        if(usertempRepository.existsUsertempByTmail(mail))
        {
            usertemp.setTid(usertempRepository.findUsertempByTmail(mail).get(0).getTid());
        }
        int code = (int)((Math.random()*9+1)*100000);
        usertemp.setTcode(Integer.toString(code));
        usertemp.setTmail(mail);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        usertemp.setTtime(sdf.format(new Date(now.getTime()+600000)));
        usertempRepository.save(usertemp);
        userService.sendEmail(mail, usertemp.getTcode());
    }
    public boolean existsByEmail(String email){
        return usertempRepository.existsUsertempByTmail(email);
    }
    public List<Usertemp> findByEmail(String email)
    {
        return usertempRepository.findUsertempByTmail(email);
    }
}
