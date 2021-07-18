package com.example.cartype.mapper;

import com.example.cartype.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 该接口所有方法的实现在resource/mapper/(classname).xml文件里面
 */
@Mapper
public interface MainMapper {

    public int insertUser(User user);
    /**
     * 通过用户id获取用户信息
     * @param id
     * @return User
     */
    public User getUserById(int id);

    /**
     * 获取所有的车辆品牌信息
     * @return List<CarBrand>
     */
    public List<CarBrand> getAllBrand();

    /**
     * 通过品牌id获取某个品牌下的所有车系
     * @param id
     * @return List<CarSeries>
     */
    public List<CarSeries> getBrandSeries(int id);

    /**
     * 通过id查找车系
     * @param id
     * @return
     */
    public CarSeries getSeriesById(int id);

    /**
     * 通过车款id查找其所属的车系信息
     * @param id
     * @return
     */
    public CarSeries getSeriesByCarId(int id);
    /**
     * 通过id查找车品牌
     * @param id
     * @return
     */
    public CarBrand getBrandById(int id);

    /**
     * 通过车系id查找其所属的车牌信息
     * @param id
     * @return
     */
    public CarBrand getBrandBySeriesId(int id);
    /**
     * 通过id查找车款
     * @param id
     * @return
     */
    public Car getCarById(int id);
    /**
     *通过车系id获取某个车系下所有的车型
     * @param id
     * @return List<Car>
     */
    public List<Car> getSeriesCar(int id);

    /**
     *插入一条预订信息
     * @param book
     * @return int
     */
    public int insertBook(Book book);

    /**
     *插入一条评分信息
     * @param score
     * @return int
     */
    public int insertScore(Score score);

    /**
     *通过用户id获取用户所有的评分信息
     * @param id
     * @return List<Score>
     */
    public List<Score> getMyScore(int id);

    /**
     * 通过用户id获取用户所有的预约试驾信息
     * @param id
     * @return List<Book>
     */
    public List<Book> getMyBook(int id);

    /**
     * 更新用户的头像
     * @param id
     * @param icon
     * @return int
     */
    public int updateIcon(int id,String icon);

    /**
     * 更新用户的个性签名
     * @param id
     * @param signature
     * @return int
     */
    public int updateSignature(int id,String signature);

    /**
     * 为book创建id
     * @return id
     */
    public int createBookId();
    public Score selectScore(Score score);
    public int updateScore(Score score);
}
