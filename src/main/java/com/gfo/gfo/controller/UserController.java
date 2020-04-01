package com.gfo.gfo.controller;

import com.gfo.gfo.Service.IUserService;
import com.gfo.gfo.Service.ex.*;
import com.gfo.gfo.dto.PageCondition;
import com.gfo.gfo.dto.PageResult;
import com.gfo.gfo.dto.Result;
import com.gfo.gfo.dto.UserCondition;
import com.gfo.gfo.entity.User;
import com.gfo.gfo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    public static final Integer OK = 2000;

    // http://localhost:8088/users/reg?username=Tom&password=1234&gender=0&phone=13100131001&email=controller@qq.com
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(OK);
        jsonResult.setMessage("注册成功！");
        return jsonResult;
    }
    /**
     * 响应正确时使用的状态码
     */


    // http://localhost:8088/users/login?username=Tom&password=1234
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<>(OK, "登录成功",data);
    }

    // http://localhost:8088/users/password/change?oldPassword=1234&newPassword=6789
    @RequestMapping("password/change")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        // 从参数session取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象的方法执行修改密码
        userService.changePassword(uid, oldPassword, newPassword, username);
        // 返回
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(OK);
        jsonResult.setMessage("密码修改成功！");
        return jsonResult;
    }

    // http://localhost:8088/users/info/change?phone=13800138888&email=root@tedu.cn&gender=0
    @RequestMapping("info/change")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        // 从session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行修改
        userService.changeInfo(uid, username, user);
        // 返回
       /* JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(OK);
        jsonResult.setMessage("修改资料成功！");*/
       return new JsonResult<>(OK,"修改资料成功！");
        /*return jsonResult;*/
    }
    /**
     * 允许上传的文件大小的上限值，以字节为单位
     */
    private static final long AVATAR_MAX_SIZE = 101 * 1024;
    /**
     * 允许上传的文件类型的集合
     */
    private static final List<String> AVATAR_TYPES = new ArrayList<>();

    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/gif");
        AVATAR_TYPES.add("image/bmp");
    }

    @PostMapping("avatar/change")
    public JsonResult<String> changeAvatar(
            MultipartFile file, HttpSession session) {
        // 日志
        System.err.println("UserController.changeAvatar()");

        // 判断文件是否为空
        boolean isEmpty = file.isEmpty();
        System.err.println("\tisEmpty=" + isEmpty);
        if (isEmpty) {
            // 上传的文件为空，则抛出异常
            throw new FileEmptyException(
                    "上传失败！请选择您要上传的文件！");
        }

        // 获取文件大小
        long size = file.getSize();
        System.err.println("\tsize=" + size);
        if (size > AVATAR_MAX_SIZE) {
            throw new FileSizeException(
                    "上传失败！不允许上传超过" +
                            (AVATAR_MAX_SIZE / 1024) + "KB的文件！");
        }

        // 获取文件的MIME类型
        String contentType = file.getContentType();
        System.err.println("\tcontentType=" + contentType);
        // 判断上传的文件类型是否符合：image/jpeg，image/png，image/gif，image/bmp
        if (!AVATAR_TYPES.contains(contentType)) {
            throw new FileTypeException(
                    "上传失败！仅允许上传以下类型的文件：" + AVATAR_TYPES);
        }

        // 获取原始文件名(客户端设备中的文件名)
        String originalFilename
                = file.getOriginalFilename();
        System.err.println("\toriginalFilename=" + originalFilename);

        // 将文件上传到哪个文件夹
        String parent = session
                .getServletContext().getRealPath("upload");
        System.err.println("\tupload path=" + parent);
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 保存上传的文件时使用的文件名
        String filename = ""
                + System.currentTimeMillis()
                + System.nanoTime();
        String suffix = "";
        int beginIndex = originalFilename
                .lastIndexOf(".");
        if (beginIndex >= 1) {
            suffix = originalFilename
                    .substring(beginIndex);
        }
        String child = filename + suffix;

        // 将客户端上传的文件保存到服务器端
        File dest = new File(parent, child);
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            throw new FileUploadStateException(
                    "上传失败！您的文件的状态异常！");
        } catch (IOException e) {
            throw new FileUploadIOException(
                    "上传失败！读写文件时出现错误，请重新上传！");
        }

        // 将保存的文件的路径记录到数据库中
        String avatar = "/upload/" + child;
        System.err.println("\tavatar path=" + avatar);
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeAvatar(uid, avatar, username);

        // 返回
        return new JsonResult<>(OK, avatar);
    }

    /**
     * 当日用户注册数控制器
     * @param day
     * @return
     */
    // http://localhost:8088/users/count？createdTime=1
    @RequestMapping("/count/{day}")
    public JsonResult<Integer> count(@PathVariable("day") Integer day) {
        Integer result = userService.showCountInfo(day);
        return new JsonResult<>(OK, "当日注册数",result);

    }


    /**
     * 分页查询控制器
     * @param condition
     * @return
     */
    //http://localhost:8088/users/list?page=4&pageSize=10
    @RequestMapping("/list")
    public Result<PageResult<PageCondition>> list(UserCondition condition){
        if (condition.getPageSize()==null){
            condition.setPageSize(999);
        }
        PageResult<User> pageInfo = userService.pageList(condition);
        return new Result().success(pageInfo);
    }



}