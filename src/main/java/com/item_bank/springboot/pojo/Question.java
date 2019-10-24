package com.item_bank.springboot.pojo;


import lombok.Data;

/**
 * @Description: 试题类
*/

@Data
public class Question {
    private Integer q_id;//试题唯一标识
    private String q_state;//试题状态
    private String q_content;//试题内容
    private String q_image_url;//试题图片存储路径
    private String q_type;//试题类型
    private String q_major;//所属专业
    private String q_subject;//所属科目
    private String chapter;//所属章节名
    private String difficulty;//难度系数
    private String knowledge;//考察的知识点
    private String upload_time;//上传时间
    private Integer t_id;//所属教师id
}
