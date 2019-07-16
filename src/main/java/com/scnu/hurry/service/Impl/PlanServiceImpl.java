package com.scnu.hurry.service.Impl;

import com.scnu.hurry.Enum.ResultEnum;
import com.scnu.hurry.Exception.HurryException;
import com.scnu.hurry.entity.Model;
import com.scnu.hurry.entity.UserInfo;
import com.scnu.hurry.repository.ModelRepository;
import com.scnu.hurry.repository.UserInfoRepository;
import com.scnu.hurry.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Integer getPlan(String openid) {
        UserInfo user = userInfoRepository.findByOpenid(openid);
        if(user == null){
            throw new HurryException(ResultEnum.USER_NOT_FOUND);
        }
        Model model = modelRepository.findByUserId(user.getUserId());

        //一天的毫秒值
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date modelCreateTime =  model.getCreateTime();
        //得到当前时间与模型创建时间的周数
        int d = (int) ((System.currentTimeMillis() - modelCreateTime.getTime()) / DAY_IN_MS) / 7;
        //得到计划的数目
        int planNum = model.getInitNum() - d;
        return planNum > 0 ? planNum : 0;
    }
}
