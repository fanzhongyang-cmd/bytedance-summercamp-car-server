package com.example.cartype.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.cartype.entity.*;
import com.example.cartype.mapper.MainMapper;
import com.example.cartype.util.ChineseCharacterUtil;
import com.example.cartype.util.FileUtil;
import com.example.cartype.util.JsonResult;
import com.example.cartype.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    public static int CODE_SUCCESS=333;
    public static int CODE_FAILURE=444;
    public static int CODE_EXCEPTION=555;
    @Autowired
    public MainMapper mapper;

    @GetMapping("/")
    @ResponseBody
    public String Test(){

        return "Hello ByteDance";
    }
    @GetMapping("/sign")
    @ResponseBody
    public JsonResult sign(@RequestParam int id,
                           @RequestParam String password){
        return new JsonResult(CODE_SUCCESS);
    }

    @GetMapping("/login")
    @ResponseBody
    public JsonResult Login(@RequestParam int id,
                            @RequestParam String password){
        try{
            User user = mapper.getUserById(id);
            if(user==null){
                User user1 = new User(id,"游客"+id,"他什么都没留下",password,User.DEFAULT_ICON);


                mapper.insertUser(user1);
                return new JsonResult(TokenUtil.sign(user1),CODE_SUCCESS);
            }
            if(password.equals(user.getPassword())){
                return new JsonResult(TokenUtil.sign(user),CODE_SUCCESS);
            }else {
                return new JsonResult(CODE_FAILURE);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @GetMapping("/brand")
    @ResponseBody
    public JsonResult getAllBrand(){
        try{
            List<CarBrand> brands = mapper.getAllBrand();
            Map<String,List<CarBrand>> sortedBrands=new HashMap<>();
            for (CarBrand brand : brands) {
//                String head = ChineseCharacterUtil.getFirstCharPinyinUpCase(brand.getName());
                String head=brand.getLetter();
                if(sortedBrands.get(head)==null){
                    List<CarBrand> l =new ArrayList<>();
                    l.add(brand);
                    sortedBrands.put(head,l);
                }else{
                    sortedBrands.get(head).add(brand);
                }
            }

            return new JsonResult(sortedBrands,CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }
    @GetMapping("/brandSeries")
    @ResponseBody
    public JsonResult getBrandSeries(@RequestParam int id){
        try{
            List<CarSeries> list=mapper.getBrandSeries(id);
            return new JsonResult(list,CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @GetMapping("/series")
    @ResponseBody
    public JsonResult getSeries(@RequestParam int id){
        try{
            return new JsonResult(mapper.getSeriesById(id),CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }
    @GetMapping("/seriesCar")
    @ResponseBody
    public JsonResult getSeriesCar(@RequestParam int id){
        try{
            return new JsonResult(mapper.getSeriesCar(id),CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @PostMapping("/book")
    @ResponseBody
    public JsonResult book(@RequestBody Book book){
        try{
            System.out.println(book.toString());
//            book.setId(mapper.createBookId());
            List<Car> list=mapper.getSeriesCar(book.getCar());
            if(list.size()!=0){   //查到车系下面的车款  表示这个车是一个车系
                book.setCar(list.get(0).getId());   //默认将车系id修改为查询到的第一个车款id
            }else{
//                book.setCar();
            }
            mapper.insertBook(book);
            return new JsonResult(CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }

    }

    @PostMapping("/score")
    @ResponseBody
    public JsonResult score(@RequestBody Score score){
        try{
//            System.out.println(score.toString());
            Score score1 = mapper.selectScore(score);
            if(score1==null){
                System.out.println("插入评分:"+score.toString());
                mapper.insertScore(score);
            }else {
                System.out.println("更新评分:"+score.toString());
                mapper.updateScore(score);
            }

            //更新车系的综合评分
            return new JsonResult(CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @GetMapping("/user/score")
    @ResponseBody
    public JsonResult getMyScore(@RequestParam int id){
        try{
            List<Score> scores=mapper.getMyScore(id);
            List<JSONObject> jsonObjects=new ArrayList<JSONObject>();
            for (Score score : scores) {
                JSONObject json = new JSONObject();
                CarSeries series=mapper.getSeriesById(score.getSeries());
                json.put("id",series.getId());
                json.put("name",series.getName());
                json.put("picture",series.getPicture());
                json.put("avgScore",series.getScore());
                json.put("myScore",score.getScore());
                jsonObjects.add(json);


            }
            return new JsonResult(jsonObjects,CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @GetMapping("/user/book")
    @ResponseBody
    public JsonResult getMyBook(@RequestParam int id){
        try{
            List<Book> books = mapper.getMyBook(id);
            List<JSONObject> jsonObjects=new ArrayList<JSONObject>();

            for (Book book : books) {
                CarSeries series = mapper.getSeriesByCarId(book.getCar());
                JSONObject json = new JSONObject();
                json.put("id",series.getId());//车系id
                json.put("name",series.getName());
                json.put("picture",series.getPicture());//车系图片
                json.put("score",series.getScore());//车系综合评分
                json.put("minPrice",series.getMinGuidePrice());//车系最低指导价
                json.put("state",book.getState());//预约状态
                json.put("time",book.getTime());
                jsonObjects.add(json);
            }
            return new JsonResult(jsonObjects,CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @PostMapping("/user/icon")
    @ResponseBody
    public JsonResult updateIcon(@RequestParam int id,
                                 @RequestBody MultipartFile icon){
        try{
            String extension=icon.getOriginalFilename().substring(icon.getOriginalFilename().lastIndexOf("."));
            File desc= FileUtil.getAbsoluteFile(FileUtil.USER_ICON_REPOSITORY+id+extension); //在本地目标文件夹下创建文件
            icon.transferTo(desc);      //把上传的文件保存到本地
            String url=desc.getName();
            mapper.updateIcon(id,url);
            return new JsonResult(url,CODE_SUCCESS);    //返回文件名
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }

    @PostMapping("/user/signature")
    @ResponseBody
    public JsonResult updateSignature(@RequestParam int id,
                                      @RequestParam String signature){
        try{
            mapper.updateSignature(id,signature);
            return new JsonResult(CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(CODE_EXCEPTION);
        }
    }




}
