package com.js.book.springboot.web;

import com.js.book.springboot.service.BotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BotController {

    private final String COMMAND_PREFIX = "!";
    private final BotService botService;

    @GetMapping("/api/bot/{cmd}")
    public String replier(@PathVariable String cmd) {
        //!로시작하는 명령어 모음
        if(cmd.startsWith(COMMAND_PREFIX)) {
            //ex)!나주날씨
            if(cmd.endsWith("날씨")) {
                return botService.getWeather(cmd);
            } else {
                return "알수 없는 명령어여유..";
            }
        } else {
            return "";
        }
    }
}