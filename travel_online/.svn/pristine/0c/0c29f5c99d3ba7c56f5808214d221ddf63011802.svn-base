package com.regino.travel.domain;

import lombok.Data;

import java.util.List;

/**
 * 分页对象
 */
@Data
public class PageBean<E> {
    private Integer totalCount; // 总记录数
    private Integer totalPage; // 总页数
    private List<E> list; // 结果集
    private Integer currentPage; // 当前页
    private Integer pageSize; // 每页个数

    private Integer begin; // 起始值
    private Integer end; // 结束值

    // 重写begin的get方法，让每次调用begin和end之前都调用一次方法


    public Integer getBegin() {
        cal();
        return begin;
    }

    // 计算方法
    public void cal() {
        if (totalPage < 10) { // 不足10页
            begin = 1;
            end = totalPage;
        } else { // 超过10页
            // 前5后4
            begin = currentPage - 5;
            end = currentPage + 4;
            // 修正起始页小于1的情况
            if (begin < 1) {
                begin = 1;
                end = begin + 9;
            }
            // 修正结束页大于总页数
            if (end > totalPage) {
                end = totalPage;
                begin = end - 9;
            }
        }
    }
}
