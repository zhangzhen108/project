package com.project.sdk.mapper.feedBack;

import com.project.sdk.dto.feedBack.FeedBack;

public interface FeedBackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feed_back
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feed_back
     *
     * @mbggenerated
     */
    int insert(FeedBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feed_back
     *
     * @mbggenerated
     */
    int insertSelective(FeedBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feed_back
     *
     * @mbggenerated
     */
    FeedBack selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feed_back
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FeedBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feed_back
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FeedBack record);
}