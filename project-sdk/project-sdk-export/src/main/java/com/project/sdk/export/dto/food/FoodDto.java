package com.project.sdk.export.dto.food;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class FoodDto implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zm_food.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zm_food.foodTypeId
     *
     * @mbggenerated
     */
    private Integer foodtypeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zm_food.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zm_food.score
     *
     * @mbggenerated
     */
    private String score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zm_food.imgUrl
     *
     * @mbggenerated
     */
    private String imgurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zm_food.name
     *
     * @mbggenerated
     */
    private String name;
    /*
    用于查询
     */
    private List<String> foodTypeIdList;
    /*
    用于查询  食品id组
     */
    private List<String> foodIdList;

    public List<String> getFoodIdList() {
        return foodIdList;
    }

    public void setFoodIdList(List<String> foodIdList) {
        this.foodIdList = foodIdList;
    }

    public List<String> getFoodTypeIdList() {
        return foodTypeIdList;
    }

    public void setFoodTypeIdList(List<String> foodTypeIdList) {
        this.foodTypeIdList = foodTypeIdList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zm_food.id
     *
     * @return the value of zm_food.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zm_food.id
     *
     * @param id the value for zm_food.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zm_food.merchantId
     *
     * @return the value of zm_food.merchantId
     *
     * @mbggenerated
     */

    public Integer getFoodtypeid() {
        return foodtypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zm_food.foodTypeId
     *
     * @param foodtypeid the value for zm_food.foodTypeId
     *
     * @mbggenerated
     */
    public void setFoodtypeid(Integer foodtypeid) {
        this.foodtypeid = foodtypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zm_food.price
     *
     * @return the value of zm_food.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zm_food.price
     *
     * @param price the value for zm_food.price
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zm_food.score
     *
     * @return the value of zm_food.score
     *
     * @mbggenerated
     */
    public String getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zm_food.score
     *
     * @param score the value for zm_food.score
     *
     * @mbggenerated
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zm_food.imgUrl
     *
     * @return the value of zm_food.imgUrl
     *
     * @mbggenerated
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zm_food.imgUrl
     *
     * @param imgurl the value for zm_food.imgUrl
     *
     * @mbggenerated
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zm_food.name
     *
     * @return the value of zm_food.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zm_food.name
     *
     * @param name the value for zm_food.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}