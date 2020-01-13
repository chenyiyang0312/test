package com.fh.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.fh.entity.StudentInfo;
import com.fh.service.StudentService;
import com.fh.utils.AliyunOssUtils;
import com.fh.utils.PageBean;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("students")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private HttpServletRequest request;
    /**
     * 查询
     * @param page
     * @return
     */
    @PostMapping("queryStudentList")
    public PageBean<StudentInfo> queryStudentList(PageBean<StudentInfo> page){
        studentService.queryStudentList(page);
        return page;
    }

    /**
     * 增加
     * @param
     * @return
     */
    @PostMapping("addStudent")
    public ResponseServer addStudent(StudentInfo studentInfo){
        String remoteAddr = request.getRemoteAddr();
        studentInfo.setIp(remoteAddr);
        studentService.addStudent(studentInfo);
        return ResponseServer.success(studentInfo);
    }

    /**
     * 图片上传
     * @param imgUrl
     * @return
     */
    //图片上传
    @PostMapping("uploadFile")
    public Map<String,Object> uploadFile(@RequestParam("imgUrl") MultipartFile imgUrl){
        Map<String,Object> map = new HashMap<String,Object>();
        AliyunOssUtils aliyunOssUtils=new AliyunOssUtils();
        String url = "";
        try {
            //获取上传的图片名称

            url = aliyunOssUtils.uploadImg2Oss(imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //拼接图片路径 并返回到前台

        String imageUrl = aliyunOssUtils.getImageUrl(url);
        map.put("data",imageUrl);
        return map;

    }


    /**
     * 回显
     */


    @GetMapping("toUpdateStudent")
    public ResponseServer toUpdateStudent(Integer id){
        StudentInfo studentInfo=studentService.toUpdateStudent(id);
        return ResponseServer.success(studentInfo);
    }


    /**
     * 修改
     */
    @PostMapping("updateStudent")
    public ResponseServer updateStudent(StudentInfo studentInfo){
        studentService.updateStudent(studentInfo);
        return ResponseServer.success(studentInfo);
    }

    /**
     * 假删
     */
    @DeleteMapping("deleteStudent")
    public void deleteStudent(Integer id) {
       StudentInfo studentInfo= studentService.toUpdateStudent(id);
       studentInfo.setIsDel(studentInfo.getIsDel()==1?2:1);
       studentService.updateStudent(studentInfo);
        ResponseServer.success(studentInfo);
    }
}
