package com.gfo.gfo.redis;

import com.alibaba.fastjson.JSON;
import com.gfo.gfo.entity.User;
import com.gfo.gfo.mapper.UserMapper;
import com.gfo.gfo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.gfo.gfo.controller.UserController.OK;

@RestController
public class Dcontroller {

    @Autowired
    private RedisService redisService ;

    @Autowired
    private UserMapper userMapper ;
    //http://localhost:8088/test

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public JsonResult<Void> demoTest(Integer uid, String username) {
        // 调用userMapper的findByUsername()方法执行查询
        User result = userMapper.findByUid(uid);
        redisService.set(result.getUid()+"", JSON.toJSONString(username));
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(OK);
        jsonResult.setMessage("添加成功！");
        jsonResult.setData(result);

        return jsonResult;
    }
 /*   @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void demoTest(){
        User user = new User();
        String username = user.getUsername();
        // 调用userMapper的findByUsername()方法执行查询
        User result = userMapper.findByUsername(username);
        redisService.set(result.toString(),"12");
    }*/

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public String get(){
        return redisService.get("qq")+"";
    }


    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public void remove(final String... keys) {
        for (String key : keys) {
            redisService.remove(keys);
        }
    }

    @RequestMapping(value = "/remo",method = RequestMethod.POST)
    public void remove(final String key) {
        redisService.remove("qq");
    }
}


