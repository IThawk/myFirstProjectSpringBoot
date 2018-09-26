package com.itHawk.springBoot.controller;

import com.itHawk.springBoot.model.ActionResult;
import com.itHawk.springBoot.service.SmallTollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tool")
public class SmallToolController {
    @Autowired
    private SmallTollService smallTollService;
    /***
     * date时间转时间戳
     * @param date 时间
     * @return
     */
    @PostMapping("/dateToStamp")
    public ActionResult dateToStamp(String date) {
        ActionResult actionResult = new ActionResult();
        Map<String, Object> data = new HashMap<>(16);
        int code = smallTollService.dateToStamp(date, data);
        actionResult.setCode(code);
        return actionResult;

    }
    /***
     * date时间转时间戳
     * 时间戳戳转date时间
     * @param stamp  时间戳
     * @return
     */
    @PostMapping("/stampToDate")
    public ActionResult stampToDate(String stamp) {
        ActionResult actionResult = new ActionResult();
        Map<String, Object> data = new HashMap<>(16);
        int code = smallTollService.stampToDate(stamp, data);
        actionResult.setCode(code);
        return actionResult;

    }

}
