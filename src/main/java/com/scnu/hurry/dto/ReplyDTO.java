package com.scnu.hurry.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReplyDTO {

    private Integer replyId;
    private Integer questionId;
    private Integer userId;
    private String replyContent;
    //回复对应的问题
    private String questionContent;
}
