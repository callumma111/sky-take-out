package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {
    /*
    * 营业额统计
    * */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);

    /*
     * 营业额统计
     * */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    /*
    * 订单统计
    * */
    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    /*
    *销量排名top10
    * */
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
