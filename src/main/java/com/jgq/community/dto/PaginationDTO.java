package com.jgq.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiGuoqing
 * @date 2019/11/3 11:33
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOList;
    private Boolean showFirstPage;
    private Boolean showEndPage;
    private Boolean showPrevious;
    private Boolean showNext;
    private Integer currentPage;
    private List<Integer> pages = new ArrayList<>();
    Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
            //计算总页数
            if (totalCount % size == 0){
                totalPage = totalCount / size;
            }else{
                totalPage = totalCount / size + 1;
            }
            if (page < 1){
                page = 1;
            }
            if (page > totalPage){
                page = totalPage;
            }
            this.currentPage = page;
            //将当前页插入展示页面数组
            pages.add(page);
            for (int i = 1 ; i <= 3 ; i++ ){
                if (page - i > 0){
                    pages.add(0,page - i);
                }
                if (page + i <= totalPage){
                    pages.add(page + i);
                }
            }
            //是否展示上一页
            if (page == 1){
                showPrevious = false;
            }else{
                showPrevious = true;
            }
            //是否展示下一页
            if (page == totalPage){
                showNext = false;
            }else{
                showNext = true;
            }
            //是否展示首页
            if (pages.contains(1)){
                showFirstPage = false;
            }else{
                showFirstPage = true;
            }
            //是否展示尾页
            if (pages.contains(totalPage)){
                showEndPage = false;
            }else{
                showEndPage = true;
            }
    }
}
